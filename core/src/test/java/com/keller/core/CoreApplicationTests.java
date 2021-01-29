package com.keller.core;

import com.keller.core.enums.MessageTypeEnums;
import com.keller.core.message.SystemMessage;
import com.keller.core.message.body.ImageBody;
import org.junit.jupiter.api.Test;

class CoreApplicationTests {

    @Test
    void test() {
        System.out.println(MessageTypeEnums.Group.name());
        System.out.println(new ImageBody());

        SystemMessage systemMessage = new SystemMessage();
        systemMessage.setEvent("e");
        System.out.println(systemMessage.toJSONString());
    }

}
