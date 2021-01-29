package com.keller.friend.client;


import com.keller.core.constant.ServiceNameConstant;
import com.keller.core.response.ServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户模块的远程调用
 * @author yangkaile
 * @date 2020-12-10 21:21:10
 */
@FeignClient(name = ServiceNameConstant.USER)
public interface UserClient {

    @GetMapping("/test")
    ServiceResponse test();
}
