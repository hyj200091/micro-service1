package com.soft1851.share.service;

import com.soft1851.share.domain.dto.LoginDto;
import com.soft1851.share.domain.dto.ResponseDTO;
import com.soft1851.share.domain.dto.UserAddBonusMsgDto;
import com.soft1851.share.domain.dto.UserSignInDTO;
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
     *
     * @param id
     * @return User
     */
    ResponseDTO findById(Integer id);

    /**
     * 修改积分 然后插入记录
     *
     * @param id
     */
    User insertById(Integer id);

    /**
     * 登录
     * @param loginDto
     * @return user
     */
    User login (LoginDto loginDto,String openId);

    /**
     * 增加积分接口
     * @param userAddBonusMsgDto
     */
    void addBonus(UserAddBonusMsgDto userAddBonusMsgDto);

    /**
     * 用户签到
     * @param userSignInDTO
     * @return
     */
    ResponseDTO signIn(UserSignInDTO userSignInDTO);

    /**
     * 判断用户是否签到
     * @param userSignInDTO
     * @return
     */
    ResponseDTO checkIsSign(UserSignInDTO userSignInDTO);
}
