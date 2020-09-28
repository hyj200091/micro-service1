package com.soft1851.share.service.impl;

import com.soft1851.share.entity.User;
import com.soft1851.share.mapper.UserMapper;
import com.soft1851.share.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/27
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        List<User> userList = userMapper.selectAll();
        return userList;
    }
}