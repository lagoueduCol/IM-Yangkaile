package com.keller.friend;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class FriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().clear();
        restTemplate.getMessageConverters().add(new FastJsonHttpMessageConverter());
        return restTemplate;

    }
}
