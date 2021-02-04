package com.keller.im.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 在线服务
 * 使用 ComponentScan 注解，指定在启动时除了扫描本服务下的组件外，还要扫描公共组件 core 下的所有Bean
 * @author yangkaile
 * @date 2021-02-04 17:37:17
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.keller.im.core","com.keller.im.message"})
@EnableDiscoveryClient
public class MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }

}
