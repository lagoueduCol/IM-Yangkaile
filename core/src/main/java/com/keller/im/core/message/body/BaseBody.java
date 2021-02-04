package com.keller.im.core.message.body;

import lombok.Data;

/**
 * 消息体基类
 * @author yangkaile
 * @date 2021-02-02 07:27:14
 */
@Data
public abstract class BaseBody {
    /**
     * 消息体类型 文本、语音、图片
     */
    private String type;
    {
        setBodyType();
    }

    /**
     * 设置消息体类型
     */
    public abstract void setBodyType();
}
