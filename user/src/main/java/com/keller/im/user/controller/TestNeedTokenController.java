package com.keller.im.user.controller;

import com.keller.log.auth.JwtEntity;
import com.keller.log.auth.JwtUtil;
import com.keller.im.core.enums.RequestHeaderEnums;
import com.keller.im.core.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试
 * @author yangkaile
 * @date 2020-12-13 01:27:42
 */
@RestController
@RequestMapping("/test")
public class TestNeedTokenController {

    @Autowired
    private HttpServletRequest request;

    /**
     * 测试需要Token才能访问的接口
     * @return
     */
    @GetMapping
    public ServiceResponse testNeedToken() {
        return ServiceResponse.success("USER：Hello  World!");
    }

    /**
     * 测试解析Token
     * @return
     */
    @GetMapping("/readToken")
    public ServiceResponse getToken(){
        String token = request.getHeader(RequestHeaderEnums.Token.name);
        JwtEntity entity = JwtUtil.readLoginToken(token);
        return ServiceResponse.success(entity);
    }
}
