package com.keller.im.log.kafka;

import com.alibaba.fastjson.JSON;
import com.keller.im.core.kafka.KafkaTopicConfig;
import com.keller.im.core.mapper.log.MailSendLogMapper;
import com.keller.im.core.po.log.LoginLog;
import com.keller.im.core.po.log.MailSendLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Kafka消费者
 * @author yangkaile
 * @date 2021-01-29 17:58:28
 */
@Component
@Slf4j
public class KafkaConsumer {
    @Resource
    private MailSendLogMapper mailSendLogMapper;

    @KafkaListener(topics = KafkaTopicConfig.TOPIC_MAIL_SEND_LOG, groupId = KafkaTopicConfig.GROUP_LOG)
    public void mailSendLogConsumer(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        Optional message = Optional.ofNullable(record.value());
        ack.acknowledge();
        if (message.isPresent()) {
            Object msg = message.get();
            if(msg instanceof String){
                MailSendLog mailSendLog = JSON.parseObject((String)msg,MailSendLog.class);
                log.info("{} 消费一条消息 {}",KafkaTopicConfig.TOPIC_MAIL_SEND_LOG,mailSendLog);
                //TODO 保存邮件发送记录
                mailSendLogMapper.baseInsertAndReturnKey(mailSendLog);
            }
        }
    }

    @KafkaListener(topics = KafkaTopicConfig.TOPIC_LOGIN_LOG, groupId = KafkaTopicConfig.GROUP_LOG)
    public void loginLogConsumer(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        Optional message = Optional.ofNullable(record.value());
        ack.acknowledge();
        if (message.isPresent()) {
            Object msg = message.get();
            if(msg instanceof String){
                LoginLog loginLog = JSON.parseObject((String)msg,LoginLog.class);
                log.info("{} 消费一条消息 {}",KafkaTopicConfig.TOPIC_LOGIN_LOG,loginLog);
                //TODO 保存登录记录
            }

        }
    }
}
