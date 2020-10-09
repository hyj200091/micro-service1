package com.soft1851.share.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @ClassName SwaggerConfiguration
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/5
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    /**
     * swagger 信息
     * @return 页面信息
     */
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "share-app Swagger 文档",
                "github地址 https://github.com/hyj200091/micro1-service",
                "API V1.0",
                "Terms of service",
                new Contact("空白","https://houyuejia.cn","yuejia200091@gmail.com"),
                "Apache","http://www.apache.org/", Collections.emptyList());

    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.soft1851.share"))
                .build()
                .apiInfo(apiInfo());
    }
}