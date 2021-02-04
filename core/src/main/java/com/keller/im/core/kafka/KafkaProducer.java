package com.keller.im.core.kafka;

import com.alibaba.fastjson.JSONObject;
import com.keller.im.core.po.log.LoginLog;
import com.keller.im.core.po.log.MailSendLog;
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


    /**
     * 邮件发送日志
     * @param log
     */
    public void sendMailSendLog(MailSendLog log){
        send(KafkaTopicConfig.TOPIC_MAIL_SEND_LOG,log);
    }

    /**
     * 发送登录日志
     * @param log
     */
    public void sendLoginLog(LoginLog log){
        send(KafkaTopicConfig.TOPIC_LOGIN_LOG,log);
    }

    private void send(String topic,Object obj) {
        String json = JSONObject.toJSONString(obj);
        log.info("准备发送消息：{}", json);
        //发送消息
        ListenableFuture future = kafkaTemplate.send(topic, json);
        future.addCallback(
                message -> log.info("消息发送成功,topic:{},message:{}", message),
                throwable -> log.error("消息发送失败,topic:{},errorMessage:{}" + throwable.getMessage())
        );
    }
}
