package com.keller.im.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 文件服务
 * 使用 ComponentScan 注解，指定在启动时除了扫描本服务下的组件外，还要扫描公共组件 core 下的所有Bean
 * @author yangkaile
 * @date 2021-02-04 17:44:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.keller.im.core","com.keller.im.file"})
public class FileApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }

}
