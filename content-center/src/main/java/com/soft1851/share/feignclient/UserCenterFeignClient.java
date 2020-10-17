package com.soft1851.share.feignclient;

import com.soft1851.share.domain.dto.ResponseDTO;
import com.soft1851.share.domain.dto.UserAddBonusDTO;
import com.soft1851.share.domain.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName UserCenterFeignClient
 * @Description用户中心对应的Feign客户端声明接口
 * @Author hyj
 * @Date 2020/9/29
 **/
// 指定到对应的服务类应用上
@FeignClient(name = "user-center")
public interface UserCenterFeignClient {
    /**
     * @param id
     * @return userDto
     */
    @GetMapping("/user/{id}")
    ResponseDTO findById(@PathVariable Integer id);

    /**
     * 修改积分 同时插入一条日志
     *
     * @param id
     */
    @GetMapping("/user/bonus/{id}")
    UserDto insertBlog(@PathVariable Integer id);

    /**
     * 用户增加积分
     * @param userAddBonusDTO
     * @return
     */
    @PutMapping("/user/add-bonus")
    UserDto addBonus(@RequestBody UserAddBonusDTO userAddBonusDTO);

    /**
     * hello 测试
     *
     * @return String
     */
    @GetMapping("/user/hello")
    String getHello();


}
