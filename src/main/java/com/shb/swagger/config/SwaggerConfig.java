package com.shb.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author
 * @version 创建时间：2020/9/17 17:11
 */
//开启Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //配置了Swagger的bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    //配置Swagger信息=apiinfo
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("宋海波", "https://blog.csdn.net/qq_41453424", "594859595@qq.com");
        return new ApiInfo(
                "宋海波的SwaggerAPI文档",
                "勤于学知，细于做事",
                "v1.0",
                "https://blog.csdn.net/qq_41453424",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
