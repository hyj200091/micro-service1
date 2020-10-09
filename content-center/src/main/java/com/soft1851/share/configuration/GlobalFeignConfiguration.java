package com.soft1851.share.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName GlobalFeignConfiguration
 * @Description 自定义配置Fegin的日志级别
 * @Author hyj
 * @Date 2020/9/29
 **/
public class GlobalFeignConfiguration {
    @Bean
    public feign.Logger.Level level(){
        //让Feign打印所有请求细节
        return Logger.Level.FULL;
    }
}