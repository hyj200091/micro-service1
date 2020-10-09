package com.soft1851.share.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soft1851.share.dao.MidUserShareMapper;
import com.soft1851.share.dao.ShareMapper;
import com.soft1851.share.domain.dto.*;
import com.soft1851.share.domain.entity.MidUserShare;
import com.soft1851.share.domain.entity.Share;
import com.soft1851.share.domain.enums.AuditStatusEnum;
import com.soft1851.share.feignclient.UserCenterFeignClient;
import com.soft1851.share.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName ShareServiceImpl
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/26
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareServiceImpl implements ShareService {
    private final ShareMapper shareMapper;
    private final UserCenterFeignClient userCenterFeignClient;
    private final MidUserShareMapper midUserShareMapper;
    private final RocketMQTemplate rocketMQTemplate;


    @Override
    public List<Share> selectAll() {
        List<Share> shareList = shareMapper.selectAll();
        return shareList;
    }

    @Override
    public ShareDto findById(Integer id) {
        //获取实体
        Share share = this.shareMapper.selectByPrimaryKey(id);
        //获得发布人id
        Integer userId = share.getUserId();
        //1 代码不可读
        //2 复杂的url难以维护
        //3 难以响应需求变化 变化没有很幸福
        //4 编程体验不统一
        UserDto userDto = this.userCenterFeignClient.findById(userId);
        ShareDto shareDto = new ShareDto();
        // 属性的装配
//        BeanUtils.copyProperties(share, shareDto);
        shareDto.setShare(share);
        shareDto.setWxNickname(userDto.getWxNickname());
        return shareDto;

    }

    @Override
    public PageInfo<Share> query(String title, Integer pageNo, Integer pageSize, Integer userId) {
        // 启动分页
        PageHelper.startPage(pageNo,pageSize);
        //构造查询实例
        Example example = new Example(Share.class);
        Example.Criteria criteria = example.createCriteria();
        //如标题关键字不空，则加上模糊查询，否则结果即所有数据
        if (StringUtil.isNotEmpty(title)){
            criteria.andLike("title","%"+ title +"%");
        }
        // 执行按条件查询
        List<Share> shares = this.shareMapper.selectByExample(example);
        // 处理后的share数据列表
        List<Share> shareDeal;
        // 1 如果用户未登录，那么downloadUrl全部设为null
        if (userId == null){
            shareDeal = shares.stream()
                    .peek(share -> {
                        share.setDownloadUrl(null);
                    })
                    .collect(Collectors.toList());
        }
        //2 如果用户登录了，那么查询一下mid——user--share，如果没有数据，那么这条share的downloadUrl也设为null
        // 只有自己分享的资源才能直接看到下载链接 ，否则显示”兑换“
        else {
            shareDeal = shares.stream()
                    .peek(share -> {
                        MidUserShare midUserShare = this.midUserShareMapper.selectOne(
                                MidUserShare.builder()
                                .userId(userId)
                                .shareId(share.getId())
                                .build()
                        );
                        if (midUserShare == null){
                            share.setDownloadUrl(null);
                        }
                    })
                    .collect(Collectors.toList());
        }
        return new PageInfo<>(shareDeal);
    }

    @Override
    public String getHello() {
        return this.userCenterFeignClient.getHello();
    }

    @Override
    public Share insertShare(ShareRequestDto shareRequestDto) {
        Share share = Share.builder()
                .title(shareRequestDto.getTitle())
                .price(shareRequestDto.getPrice())
                .summary(shareRequestDto.getSummary())
                .author(shareRequestDto.getAuthor())
                .isOriginal(shareRequestDto.getIsOriginal())
                .userId(1)
                .downloadUrl(shareRequestDto.getDownloadUrl())
                .createTime(new Date())
                .updateTime(new Date())
                .cover("默认")
                .buyCount(10)
                .auditStatus("NOT_YET")
                .showFlag(1)
                .reason("no")
                .build();
        int n  = this.shareMapper.insert(share);
        if (n ==1){
            System.out.println("插入成功");
        }
        return share;
    }

    @Override
    public Share auditById(Integer id, ShareAuditDto shareAuditDto) {
        // 1 查询share是否存在，不存在或者当前的audit_status！= NOT_YET ,那么抛异常
        Share share = this.shareMapper.selectByPrimaryKey(id);
        if (share == null){
            throw new IllegalArgumentException("参数非法！该分析不存在");
        }
        if (!Objects.equals("NOT_YET",share.getAuditStatus())){
            throw new IllegalArgumentException("参数非法！该分享已审核或者审核不通过！");
        }
        // 2 审核资源 将状态改为PASS或REJECT
        // 这个API的主要流程是审核，所以不需要等更新积分的结果返回，可以将积分改为异步
        share.setAuditStatus(shareAuditDto.getAuditStatusEnum().toString());
        this.shareMapper.updateByPrimaryKey(share);

        //3 如果是PASS，那么发送消息给rocketmq,让用户中心去消费 并为发布人添加积分
        if (AuditStatusEnum.PASS.equals(shareAuditDto.getAuditStatusEnum())){
            this.rocketMQTemplate.convertAndSend(
                    "add-bonus",
                    UserAddBonusMsgDto.builder()
                    .userId(share.getUserId())
                    .bonus(50)
                    .build());
        }
        return share;
    }

    @Override
    public Share insertBlog(Integer id, ShareAuditDto shareAuditDto) {
        // 1 查询share是否存在，不存在或者当前的audit_status！= NOT_YET ,那么抛异常
        Share share = this.shareMapper.selectByPrimaryKey(id);
        if (share == null){
            throw new IllegalArgumentException("参数非法！该分析不存在");
        }
        if (!Objects.equals("NOT_YET",share.getAuditStatus())){
            throw new IllegalArgumentException("参数非法！该分享已审核或者审核不通过！");
        }
        int userId = share.getUserId();
        // 2 审核资源 将状态改为PASS或REJECT
        // 这个API的主要流程是审核，所以不需要等更新积分的结果返回，可以将积分改为异步
        share.setAuditStatus(shareAuditDto.getAuditStatusEnum().toString());
        this.shareMapper.updateByPrimaryKey(share);

        //3 如果是PASS，那么发送消息给rocketmq,让用户中心去消费 并为发布人添加积分
        if (AuditStatusEnum.PASS.equals(shareAuditDto.getAuditStatusEnum())){
            // 使用Feign来调用用户中心更改积分的接口（同步）
            this.userCenterFeignClient.insertBlog(userId);
        }
        return share;
    }
}