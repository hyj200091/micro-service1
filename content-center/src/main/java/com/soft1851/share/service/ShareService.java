package com.soft1851.share.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.share.domain.dto.ExchangeDTO;
import com.soft1851.share.domain.dto.ShareAuditDto;
import com.soft1851.share.domain.dto.ShareDto;
import com.soft1851.share.domain.dto.ShareRequestDto;
import com.soft1851.share.domain.entity.Share;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName ShareService
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/26
 **/
public interface ShareService {
    /**
     * 查询所有的share
     *
     * @return list
     */
    List<Share> selectAll();

    /**
     * 获得分享详情
     *
     * @param id
     * @return ShareDto
     */
    ShareDto findById(Integer id);

    /**
     * 根据标题模糊查询某个用户的分享列表数据，title为空则是所有数据，查询结果分页
     *
     * @param title
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return
     */
    PageInfo<Share> query(String title, Integer pageNo, Integer pageSize, Integer userId);

    /**
     * 格式feign
     *
     * @return string
     */
    String getHello();

    /**
     * 新增一条投稿信息
     *
     * @param shareRequestDto
     * @return int
     */
    Share insertShare(ShareRequestDto shareRequestDto);

    /**
     * 审核投稿
     *
     * @param id
     * @param shareAuditDto
     * @return share
     */
    Share auditById(Integer id, ShareAuditDto shareAuditDto);

    /**
     * 积分兑换资源
     *
     * @param exchangeDTO
     * @return Share
     */
    Share exchange(ExchangeDTO exchangeDTO);

    /**
     * 修改积分并且打印日志
     *
     * @param id * @param shareAuditDto
     * @return share
     */
    Share insertBlog(@PathVariable Integer id, ShareAuditDto shareAuditDto);
}
