package com.soft1851.share.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.soft1851.share.dao.BonusEventLogMapper;
import com.soft1851.share.dao.UserMapper;
import com.soft1851.share.domain.dto.LoginDto;
import com.soft1851.share.domain.dto.ResponseDTO;
import com.soft1851.share.domain.dto.UserAddBonusMsgDto;
import com.soft1851.share.domain.dto.UserSignInDTO;
import com.soft1851.share.domain.entity.BonusEventLog;
import com.soft1851.share.domain.entity.User;
import com.soft1851.share.service.UserService;
import com.soft1851.share.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/27
 **/
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;
    private final RestTemplate restTemplate;
    private final WxMaService wxMaService;

    @Override
    public ResponseDTO findById(Integer id) {
        User user =  this.userMapper.selectByPrimaryKey(id);
        return new ResponseDTO(true,"200","查询成功",user,1l);
    }

    @Override
    public User insertById(Integer id) {
        User user = this.userMapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new IllegalArgumentException("参数非法！无此用户");
        }
        user.setBonus(user.getBonus() + 50);
        this.userMapper.updateByPrimaryKey(user);
        BonusEventLog bonusEventLog = BonusEventLog.builder()
                .userId(id)
                .createTime(new Date())
                .description("投稿加分")
                .value(50)
                .event("CONTRIBUTE")
                .build();
        this.bonusEventLogMapper.insert(bonusEventLog);
        return user;
    }

    @Override
    public User login(LoginDto loginDto,String openId) {
        // 先根据wxId查找用户
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wxId",openId);
        List<User> users = this.userMapper.selectByExample(example);
        //没找到用户,是新用户，直接注册
        if (users.size() == 0){
            User user = User.builder()
                    .wxId(openId)
                    .avatarUrl(loginDto.getAvatarUrl())
                    .wxNickname(loginDto.getWxNickname())
                    .roles("user")
                    .bonus(100)
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            this.userMapper.insertSelective(user);
            System.out.println("插入一个新用户");
            return user;
        }
        return users.get(0);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBonus(UserAddBonusMsgDto userAddBonusMsgDto) {
        System.out.println(userAddBonusMsgDto);
        // 1 为用户增加积分
        Integer userId = userAddBonusMsgDto.getUserId();
        Integer bonus = userAddBonusMsgDto.getBonus();
        User user = this.userMapper.selectByPrimaryKey(userId);

        user.setBonus(user.getBonus()+bonus);
        this.userMapper.updateByPrimaryKey(user);

        //2 记录日志到bonus_event_log表里面
        this.bonusEventLogMapper.insert(
                BonusEventLog.builder()
                        .userId(userId)
                        .value(bonus)
                        .event(userAddBonusMsgDto.getEvent())
                        .createTime(new Date())
                        .description(userAddBonusMsgDto.getDescription())
                        .build()
        );
        log.info("积分添加完毕。。。");

    }

    @Override
    public ResponseDTO signIn(UserSignInDTO signInDTO) {
        User user = this.userMapper.selectByPrimaryKey(signInDTO.getUserId());
        if (user == null){
            throw new IllegalArgumentException("该用户不存在!");
        }
        Example example = new Example(BonusEventLog.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id DESC");
        criteria.andEqualTo("userId",signInDTO.getUserId());
        log.info(String.valueOf(signInDTO.getUserId()));
        criteria.andEqualTo("event","SIGN_IN");
        List<BonusEventLog> bonusEventLog = this.bonusEventLogMapper.selectByExample(example);
        //判断查出来的bunusEventLog是否为空，空则直接插入，不为空再进行时间的判断，否则会报下标越界，就这么加，两个方法都加
        if (bonusEventLog.size() ==0){
            BonusEventLog bonusEventLog1 = BonusEventLog.builder()
                    .userId(signInDTO.getUserId())
                    .value(20)
                    .event("SIGN_IN")
                    .createTime(new Date())
                    .description("签到加分")
                    .build();
            this.bonusEventLogMapper.insert(bonusEventLog1);
            user.setBonus(20+user.getBonus());
            this.userMapper.updateByPrimaryKey(user);
        }else {
            BonusEventLog bonusEventLog1 = bonusEventLog.get(0);
            Date date = bonusEventLog1.getCreateTime();
            try {
                if (DateUtil.checkAllotSign(date) == 0) {
                    this.bonusEventLogMapper.insert(BonusEventLog.builder()
                            .userId(signInDTO.getUserId())
                            .event("SIGN_IN")
                            .value(20)
                            .description("签到加分")
                            .createTime(new Date())
                            .build());
                    return new ResponseDTO(true, "200", "签到成功", user + "用户签到成功", 1l);
                } else if (DateUtil.checkAllotSign(date) == 1) {
                    return new ResponseDTO(false, "201", "签到失败", user.getWxNickname() + "今天已经签到过了", 1l);
                } else if (DateUtil.checkAllotSign(date) == 2) {
                    return new ResponseDTO(false, "202", "签到失败", user.getWxNickname() + "用户，今天数据错乱了", 1l);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseDTO(true,"200","签到成功",user+"签到成功",1l);
    }

    @Override
    public ResponseDTO checkIsSign(UserSignInDTO signInDTO) {
        User user = this.userMapper.selectByPrimaryKey(signInDTO.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("该用户不存在");
        }
        Example example = new Example(BonusEventLog.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id DESC");
        criteria.andEqualTo("userId", signInDTO.getUserId());
        criteria.andEqualTo("event", "SIGN_IN");
        List<BonusEventLog> bonusEventLog = this.bonusEventLogMapper.selectByExample(example);
        //判断查出来的bunusEventLog是否为空
        if (bonusEventLog.size() == 0) {
            return new ResponseDTO(true,"200","该用户还没有签到","可以签到",1l);
        } else {
            BonusEventLog bonusEventLog1 = bonusEventLog.get(0);
            Date date = bonusEventLog1.getCreateTime();
            try {
                if (DateUtil.checkAllotSign(date) == 0) {
                    return new ResponseDTO(true, "200", "该用户还没有签到", "可以签到", 1l);
                } else if (DateUtil.checkAllotSign(date) == 1) {
                    return new ResponseDTO(false, "201", "已经签到了", "不可以签到", 1l);
                } else if (DateUtil.checkAllotSign(date) == 2) {
                    return new ResponseDTO(false, "202", "数据出错了", "不可以签到", 1l);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return new ResponseDTO(true, "200", "该用户还没有签到", "可以签到", 1l);
    }
}