package com.keller.im.core.kafka;

/**
 * KafkaTopic配置
 * @author yangkaile
 * @date 2021-01-29 17:50:41
 */
public class KafkaTopicConfig {
    /**
     * 日志组
     */
    public static final String GROUP_LOG = "group.log";

    /**
     * 邮件发送日志
     */
    public static final String TOPIC_MAIL_SEND_LOG = "topic.mailSendLog";

    /**
     * 登录日志
     */
    public static final String TOPIC_LOGIN_LOG = "topic.loginLog";
}
