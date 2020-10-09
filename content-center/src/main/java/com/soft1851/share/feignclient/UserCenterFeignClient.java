package com.soft1851.share.feignclient;

import com.soft1851.share.domain.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName UserCenterFeignClient
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/29
 **/
// 指定到对应的服务类应用上
@FeignClient(name = "user-center")
public interface UserCenterFeignClient {
    /**
     * @param  id
     * @return userDto
     */
    @GetMapping("/user/{id}")
    UserDto findById(@PathVariable Integer id);

    /**
     * 修改积分 同时插入一条日志
     * @param id
     */
    @GetMapping("/user/bonus/{id}")
    UserDto insertBlog(@PathVariable Integer id);


    /**
     * hello 测试
     * @return String
     */
    @GetMapping("/user/hello")
    String getHello();


}
