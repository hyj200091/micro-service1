package com.soft1851.share.service;

import com.soft1851.share.domain.entity.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/27
 **/
public interface UserService {
    /**
     * 根据id获得用户详情
     * @param id
     * @return User
     */
    User findById(Integer id);

    /**
     * 修改积分 然后插入记录
     * @param id
     */
    User insertById(Integer id);
}
