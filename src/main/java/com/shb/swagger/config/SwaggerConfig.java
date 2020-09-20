package com.shb.swagger.config;

import com.shb.swagger.controller.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.web.Swagger2Controller;

import java.util.ArrayList;

/**
 * @author
 * @version 创建时间：2020/9/17 17:11
 */
//开启Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    //配置了Swagger的bean实例
    @Bean
    public Docket docket(Environment environment) {
        //设置要显示的Swagger环境
        Profiles profiles=Profiles.of("dev");
        //获取项目环境
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("宋海波")
                .enable(flag)//enable():是否启动Swagger默认是true启动
                .select()
                //RequestHandlerSelectors，配置要扫描接口的方式
                //basePackage:指定扫描的包，例如："com.shb.swagger.controller"
                //any():扫描全部
                //none():都不扫描
                //withClassAnnotation():扫描类上注解，参数是注解的反射对象
                //withMethodAnnotation():扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.shb.swagger.controller"))
                //paths()。过滤什么路径
                //.paths(PathSelectors.ant("/shb/**"))
                .build();
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
