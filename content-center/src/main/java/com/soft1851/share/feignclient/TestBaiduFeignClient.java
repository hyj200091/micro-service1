package com.soft1851.share.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName TestBaiduFeignClient
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/30
 **/
@FeignClient(name = "baidu",url = "http://www.baidu.com")
public interface TestBaiduFeignClient {
    /**
     * 第三方接入 不是本地的模块
     * @return
     */
    @GetMapping("")
    String index();
}
