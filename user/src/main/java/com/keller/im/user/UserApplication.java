package com.keller.im.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用户模块，负责注册、登录、用户名片、用户设置
 * 使用 ComponentScan 注解，指定在启动时除了扫描本服务下的组件外，还要扫描公共组件 core 下的所有Bean
 * @author yangkaile
 * @date 2020-12-10 17:26:49
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.keller.im.core","com.keller.im.user"})
@EnableDiscoveryClient
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
