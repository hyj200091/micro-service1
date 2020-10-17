package com.soft1851.share.service;

import com.soft1851.share.domain.entity.BonusEventLog;

import java.util.List;

/**
 * @ClassName BonusEventLogService
 * @Description 积分明细借口
 * @Author hyj
 * @Date 2020/10/16
 **/
public interface BonusEventLogService {
    /**
     * 根据userId查询该用户的积分明细
     * @param userId
     * @return
     */
    List<BonusEventLog> getBonusList(Integer userId);
}
