package com.sso.demo.controller;

import com.sbt.domain.SsoUser;
import com.sbt.exception.HttpResult;
import com.sbt.util.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lww
 * @date 2020-08-19 15:21
 */
@Api(value = "/user", tags = "123")
@RestController
@RequestMapping("/user")
@Slf4j
public class DemoController {

    @ApiOperation("Hello")
    @GetMapping(value = "/hello", name = "Hello")
    public String hello() {
        return "Hello World";
    }

    @ApiOperation("登录")
    @PostMapping(value = "/login", name = "登录")
    public HttpResult login() {
        SsoUser user = new SsoUser();
        user.setUserId(12L);
        user.setMemberId(123L);
        user.setEcUserId(1234L);
        user.setName("haha");
        user.setMobile("13912345678");
        user.setEmail("lerder@foxmail.com");
        user.setIdcardNo("1237593745098432");
        user.setStatus(1);
        SessionUtil.setUser(user, true);
        return HttpResult.success();
    }

    @ApiOperation("获取用户")
    @GetMapping(value = "/user", name = "获取用户")
    public HttpResult user() {
        SsoUser user = SessionUtil.getUser();
        Long userId = SessionUtil.getUserId();
        String name = SessionUtil.getName();
        String mobile = SessionUtil.getMobile();
        return HttpResult.success(user);
    }

    @ApiOperation("登出")
    @GetMapping(value = "/logout", name = "登出")
    public HttpResult logout() {
        SessionUtil.loginOut();
        return HttpResult.success();
    }

}
