package com.keller.im.core.message.body;

import com.keller.im.core.enums.MessageBodyEnums;
import com.keller.im.core.enums.MessageBodyEnums;
import lombok.Data;

/**
 * 图片消息
 * @author yangkaile
 * @date 2021-01-21 16:04:00
 */
@Data
public class ImageBody extends BaseBody {

    /**
     * 图片地址
     */
    private String url;

    /**
     * 缩略图地址
     */
    private String thumUrl;

    @Override
    public void setBodyType() {
        this.setType(MessageBodyEnums.Image.name());
    }

    @Override
    public String toString() {
        return super.toString() + ",ImageBody{" +
                "url='" + url + '\'' +
                ", thumUrl='" + thumUrl + '\'' +
                '}';
    }

}
