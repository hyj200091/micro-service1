package com.soft1851.share.dao;

import com.soft1851.share.domain.entity.BonusEventLog;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName BonusEventLogMapper
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/8
 **/
@org.apache.ibatis.annotations.Mapper
@Component(value = "BonusEventLogMapper")
public interface BonusEventLogMapper extends Mapper<BonusEventLog> {
}
