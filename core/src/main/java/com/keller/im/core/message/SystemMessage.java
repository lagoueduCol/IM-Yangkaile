package com.keller.im.core.message;

import com.alibaba.fastjson.JSON;
import com.keller.im.core.message.enums.MessageTypeEnums;
import com.keller.im.core.message.body.BaseBody;
import lombok.Data;

/**
 * 系统消息
 * @author yangkaile
 * @date 2021-01-21 16:59:28
 */
@Data
public class SystemMessage extends BaseMessage{
    private String event;

    public SystemMessage() {
    }
    public SystemMessage(String event, Long userId, BaseBody body) {
        this.event = event;
        this.setToId(userId);
        this.setSendTime(System.currentTimeMillis());
        this.setBody(body);
    }
    @Override
    public void setType() {
        this.setType(MessageTypeEnums.System.name());
    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}
