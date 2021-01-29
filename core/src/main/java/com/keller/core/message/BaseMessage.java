package com.keller.core.message;

import com.keller.core.enums.MessageTypeEnums;
import com.keller.core.message.body.BaseBody;
import lombok.Data;

@Data
public abstract class BaseMessage {
    private String type;
    private Long fromId;
    private Long toId;
    private Long sendTime;

    private BaseBody body;

    {
        setType();
    }

    /**
     * 设置消息类型
     * @return
     */
    public abstract void setType();

    /**
     * 转成JSON
     * @return
     */
    public abstract String toJSONString();

}
