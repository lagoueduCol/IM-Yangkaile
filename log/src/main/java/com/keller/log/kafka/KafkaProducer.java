package com.keller.log.kafka;

import com.alibaba.fastjson.JSONObject;
import com.keller.core.config.KafkaTopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

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
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(Object obj) {
        String obj2String = JSONObject.toJSONString(obj);
        log.info("准备发送消息为：{}", obj2String);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(KafkaTopicConfig.TOPIC_TEST1, obj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                log.info(KafkaTopicConfig.TOPIC_TEST1 + " - 生产者 发送消息失败：{}" , throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //成功的处理
                log.info(KafkaTopicConfig.TOPIC_TEST2 + " - 生产者 发送消息成功：{}" , stringObjectSendResult.toString());
            }
        });


    }
}
