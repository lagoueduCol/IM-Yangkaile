package com.keller.im.core.util;

import java.util.UUID;

public class UuidUtils {
    /**
     * 获取UUID(32位的字母数字的集合)
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

}
