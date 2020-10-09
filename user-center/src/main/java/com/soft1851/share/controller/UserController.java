package com.soft1851.share.controller;

import com.soft1851.share.domain.entity.User;
import com.soft1851.share.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    public String getHello() {
        log.info("我被cpdd了。。");
        return "hello! this message is from user-center ";
    }

    @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable Integer id) {
        log.info("我被请求了...");
        return this.userService.findById(id);
    }

    @GetMapping(value = "/bonus/{id}")
    public User insertBlog(@PathVariable Integer id) {
        return this.userService.insertById(id);
    }

    @GetMapping("/q")
    public User query(User user) {
        return user;
    }

    /**
     * 测试异步操作
     */
    @RequestMapping("/demo")
    public String demo() {
        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Date() + "--->>>30秒。。。。";
    }
}