package com.soft1851.share.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName RibbonConfiguration
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/25
 **/
//@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}