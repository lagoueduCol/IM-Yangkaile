package com.keller.message.util;

import com.keller.core.enums.SystemMessageEventEnums;
import com.keller.core.message.SystemMessage;
import com.keller.core.message.body.TextBody;
import com.keller.message.constant.MessageConstant;

/**
 * 消息构建器
 * @author yangkaile
 * @date 2021-01-21 17:21:14
 */
public class MessageBuilder {

    public static String hello(Long userId){
        String event = SystemMessageEventEnums.Hello.name();
        TextBody body = new TextBody(MessageConstant.Hello);
        SystemMessage message = new SystemMessage(event,userId,body);
        return message.toJSONString();
    }

    public static void main(String[] args) {
        System.out.println(hello(100L));
    }
}