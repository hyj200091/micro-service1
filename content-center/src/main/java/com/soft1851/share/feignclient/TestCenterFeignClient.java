package com.soft1851.share.feignclient;

import com.soft1851.share.domain.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName TestCenterFeignClient
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/30
 **/
// 指定到对应的服务类应用上
@FeignClient(name = "user-center")
public interface TestCenterFeignClient {

    /**
     * 查询某个User对象
     *
     * @param userDto
     * @return userDto
     */
    @GetMapping("/user/q")
    UserDto query(@SpringQueryMap UserDto userDto);
}
