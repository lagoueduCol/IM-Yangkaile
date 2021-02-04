package com.keller.im.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 网关，负责路由、鉴权
 * 使用 ComponentScan 注解，指定在启动时除了扫描本服务下的组件外，还要扫描公共组件 core 下的所有Bean
 * @author yangkaile
 * @date 2020-12-10 17:13:52
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.keller.im.core","com.keller.im.gateway"})
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
