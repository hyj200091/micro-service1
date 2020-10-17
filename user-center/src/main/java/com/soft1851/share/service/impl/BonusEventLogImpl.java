package com.soft1851.share.service.impl;

import com.soft1851.share.dao.BonusEventLogMapper;
import com.soft1851.share.domain.entity.BonusEventLog;
import com.soft1851.share.service.BonusEventLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName BonusEventLogImpl
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/16
 **/
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BonusEventLogImpl implements BonusEventLogService {
    private final BonusEventLogMapper bonusEventLogMapper;
    @Override
    public List<BonusEventLog> getBonusList(Integer userId) {
        Example example = new Example(BonusEventLog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        List<BonusEventLog> list = this.bonusEventLogMapper.selectByExample(example);
        return list;
    }
}