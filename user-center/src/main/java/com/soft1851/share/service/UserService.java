package com.soft1851.share.service;

import com.soft1851.share.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/27
 **/
public interface UserService {
    /**
     * 查询所有User信息
     * @return list
     */
    List<User> selectAll();
}
