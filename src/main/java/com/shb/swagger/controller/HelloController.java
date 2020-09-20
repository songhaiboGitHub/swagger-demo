package com.shb.swagger.controller;

import com.shb.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @version 创建时间：2020/9/17 16:34
 */

@RestController
public class HelloController {
    @GetMapping(value="/hello")
    public String hello() {
        return "hello";
    }

    //只要我们的接口中返回值中存在实体类，他就会扫描到Swagger中
    @PostMapping(value="/user")
    public User user(){
        return new User();

    }
    //Operation接口,放在方法上
    @ApiOperation("hello 控制类")
    @GetMapping(value="/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }


    @PostMapping(value="/postt")
    public User postt(User user){
        return user;
    }
}
