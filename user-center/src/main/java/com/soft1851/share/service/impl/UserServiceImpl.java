package com.soft1851.share.service.impl;

import com.soft1851.share.dao.BonusEventLogMapper;
import com.soft1851.share.dao.UserMapper;
import com.soft1851.share.domain.entity.BonusEventLog;
import com.soft1851.share.domain.entity.User;
import com.soft1851.share.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Override
    public User findById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User insertById(Integer id) {
        User user = this.userMapper.selectByPrimaryKey(id);
        if (user == null){
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
}