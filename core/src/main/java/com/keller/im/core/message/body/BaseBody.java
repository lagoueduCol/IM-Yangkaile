package com.keller.im.core.message.body;

import lombok.Data;

@Data
public abstract class BaseBody {
    private String type;
    {
        setBodyType();
    }
    public abstract void setBodyType();
}
