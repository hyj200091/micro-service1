package com.soft1851.share.controller;

import com.soft1851.share.entity.User;
import com.soft1851.share.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/23
 **/
@RequestMapping("/user")
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping("/hello")
    public String getHello(){
        log.info("我被cpdd了。。");
        return "hello! this message is from user-center ";
    }

    @GetMapping("/list")
    public List<User> getUserList(){
        return userService.selectAll();
    }
}