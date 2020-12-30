package com.keller.user.controller;

import com.keller.core.MyResponse;
import com.keller.core.auth.JwtUtil;
import com.keller.core.constant.RequestConstant;
import com.keller.core.enums.RoleEnums;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 免鉴权接口：注册、登录、找回密码
 * @author yangkaile
 * @date 2020-12-11 19:11:55
 */
@RestController
@RequestMapping(RequestConstant.OPEN_URL)
public class TestOpenController {

    /**
     * 测试生成Token
     * @return
     */
    @PostMapping("/getToken")
    public MyResponse getToken(){
        String token = JwtUtil.buildLoginToken(1001,RoleEnums.Admin);

        return MyResponse.success(token);
    }
}
