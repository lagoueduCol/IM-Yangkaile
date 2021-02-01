package com.keller.im.core.message.body;

import com.keller.im.core.enums.MessageBodyEnums;
import com.keller.im.core.enums.MessageBodyEnums;
import lombok.Data;

/**
 * 文本消息
 * @author yangkaile
 * @date 2021-01-21 16:29:46
 */
@Data
public class TextBody extends BaseBody {

    private String content;

    public TextBody() {
    }

    public TextBody(String content) {
        this.content = content;
    }

    @Override
    public void setBodyType() {
        this.setType(MessageBodyEnums.Text.name());
    }
}
