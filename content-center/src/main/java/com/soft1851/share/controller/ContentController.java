package com.soft1851.share.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.Date;

/**
 * @ClassName ContentController
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/23
 **/
@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ContentController {

    private final AsyncRestTemplate asyncRestTemplate;

//    private final RestTemplate restTemplate;
//
//    @GetMapping("/hello")
//    public String getHello() throws InterruptedException {
//        return restTemplate.getForObject("http://localhost:8005/user/hello",String.class);
//    }

    @RequestMapping("/async")
    public String async() {
        String url = "http://localhost:9897/user/demo";
        ListenableFuture<ResponseEntity<String>> forEntity = asyncRestTemplate.getForEntity(url, String.class);
        //异步调用后的回调函数
        forEntity.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
            //调用失败
            @Override
            public void onFailure(Throwable ex) {
                System.err.println("-----调用接口失败-------");
            }

            //调用成功
            @Override
            public void onSuccess(ResponseEntity<String> result) {
                System.out.println("--->异步调用成功, result = " + result.getBody());
            }
        });
        return new Date() + "--->>>异步调用结束";
    }

}