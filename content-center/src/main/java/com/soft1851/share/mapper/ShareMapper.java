package com.soft1851.share.mapper;

import com.soft1851.share.entity.Share;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName ShareMapper
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/26
 **/
@org.apache.ibatis.annotations.Mapper
@Component(value = "ShareMapper")
public interface ShareMapper extends Mapper<Share> {
}
