package com.soft1851.share.service;

import org.springframework.web.client.RestTemplate;

/**
 * @ClassName SentinelTest
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/6
 **/
public class SentinelTest {
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 100; i++) {
            String object = restTemplate.getForObject("http://localhost:9595/api/ByResource", String.class);
            System.out.println("ok");
            System.out.println(object);
        }
    }
}