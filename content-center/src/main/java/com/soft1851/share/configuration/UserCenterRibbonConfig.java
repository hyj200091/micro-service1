package com.soft1851.share.configuration;

import com.soft1851.share.ribbonconfig.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName UserCenterRibbonConfig
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/25
 **/

@Configuration
//@RibbonClient(name = "user-center",configuration = RibbonConfiguration.class)
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class UserCenterRibbonConfig {
}