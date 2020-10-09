package com.soft1851.share;

import com.purgeteam.dispose.starter.annotation.EnableGlobalDispose;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;
import tk.mybatis.spring.annotation.MapperScan;


@EnableGlobalDispose
@MapperScan("com.soft1851.share.dao")
@SpringBootApplication
@EnableFeignClients
//@EnableFeignClients(defaultConfiguration = GlobalFeignConfiguration.class)
public class ContentCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class, args);
    }

    /**
     * 创建一个restTemplate实例
     * @return RestTemplate
     */
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    @Bean
    public AsyncRestTemplate restTemplate(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // 设置链接超时时间
        factory.setConnectTimeout(100);
        // 设置读取资料超时时间
        factory.setReadTimeout(200);
        // 设置异步任务(线程不会重用，每次调用都会重新启动一个新的线程)
        factory.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return new AsyncRestTemplate();
    }
}
