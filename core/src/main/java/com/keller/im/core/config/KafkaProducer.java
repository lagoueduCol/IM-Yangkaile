package com.keller.im.core.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/**
 * Kafka 生产者
 * @author yangkaile
 * @date 2021-01-29 14:33:23
 */
@Component
@Slf4j
public class KafkaProducer {

    @Resource
    private KafkaTemplate kafkaTemplate;

    public void send(String topic,Object obj) {
        String obj2String = JSONObject.toJSONString(obj);
        log.info("准备发送消息为：{}", obj2String);
        //发送消息
        ListenableFuture future = kafkaTemplate.send(topic, obj2String);
        future.addCallback(
                message -> log.info("消息发送成功,topic:{},message:{}", message),
                throwable -> log.error("消息发送失败,topic:{},message:{}" + throwable.getMessage())
        );
    }
}
