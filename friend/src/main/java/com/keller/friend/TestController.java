package com.keller.friend;

import com.keller.core.MyResponse;
import com.keller.friend.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试Controller
 * @author yangkaile
 * @date 2020-12-10 21:58:50
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private UserClient userClient;

    @GetMapping
    public String test() {
        return "Friend：Hello World!";
    }

    @GetMapping("/user")
    public MyResponse getUser(){
        List<ServiceInstance> instances = discoveryClient.getInstances("user");
        if(instances == null || instances.isEmpty()){
            return MyResponse.error("Not Found!");
        }
        ServiceInstance instance = instances.get(0);
        System.out.println(instance.getHost());
        System.out.println(instance.getPort());
        System.out.println(instance.getUri());
        String url = instance.getUri() + "/test";
        ResponseEntity<MyResponse> responseEntity = restTemplate.getForEntity(url,MyResponse.class);
        MyResponse response = responseEntity.getBody();
        System.out.println(response);
        return response;
    }

    @GetMapping("/feignUser")
    public MyResponse feignUser(){
        return userClient.test();
    }
}
