package com.keller.user.controller;

import com.keller.core.MyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试管理员接口
 * @author yangkaile
 * @date 2020-12-13 02:06:16
 */
@RestController
@Slf4j
@RequestMapping("/admin")
public class TestAdminController {

    /**
     * 只允许管理员访问的接口
     * @return
     */
    @GetMapping
    public MyResponse test(){
        return MyResponse.success("User Admin!");
    }
}
