package com.soft1851.share.mapper;

import com.soft1851.share.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/27
 **/
@org.apache.ibatis.annotations.Mapper
@Component(value = "UserMapper")
public interface UserMapper extends Mapper<User> {
}
