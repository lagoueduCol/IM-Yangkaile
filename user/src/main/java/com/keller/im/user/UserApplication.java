package com.keller.im.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户模块，负责注册、登录、用户名片、用户设置
 * @author yangkaile
 * @date 2020-12-10 17:26:49
 */
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
