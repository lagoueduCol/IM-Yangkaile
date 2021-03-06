package com.keller.im.log.test;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.kafka.KafkaTopicConfig;
import com.keller.im.core.po.log.LoginLog;
import com.keller.im.core.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private KafkaProducer kafkaProducer;

    @GetMapping("/kafka")
    public ServiceResponse kafka(){
        LoginLog loginLog = new LoginLog();
        loginLog.setId(123L);
        loginLog.setIp("你好啊");
        kafkaProducer.sendLoginLog(loginLog);
        return ServiceResponse.success();
    }

}
