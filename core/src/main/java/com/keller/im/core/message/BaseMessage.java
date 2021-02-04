package com.keller.im.core.message;

import com.keller.im.core.message.body.BaseBody;
import lombok.Data;

/**
 * 消息基类
 * @author yangkaile
 * @date 2021-02-02 07:23:49
 */
@Data
public abstract class BaseMessage {

    /**
     * 消息类型 系统消息、单聊、群聊
     */
    private String type;
    /**
     * 发送人
     */
    private Long fromId;
    /**
     * 接收人
     */
    private Long toId;
    /**
     * 发送时间
     */
    private Long sendTime;

    /**
     * 消息体
     */
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
