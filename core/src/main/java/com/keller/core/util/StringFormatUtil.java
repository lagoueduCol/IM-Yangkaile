package com.keller.core.util;

import com.keller.core.enums.UserNameTypeEnums;

import java.util.regex.Pattern;

/**
 * 字符串格式工具类
 */
public class StringFormatUtil {

    public static final String userNameFormat = "";

    public static final String emailFormat = "";

    public static final String phoneFormat = "";


    /**
     * 匹配用户名类型
     * @param name
     * @return
     */
    public static UserNameTypeEnums matchesUserNameType(String name){
        if(Pattern.matches(userNameFormat, name)){
            return UserNameTypeEnums.UserName;
        }else if(Pattern.matches(emailFormat, name)){
            return UserNameTypeEnums.Mail;
        }else if(Pattern.matches(phoneFormat, name)){
            return UserNameTypeEnums.Phone;
        }else{
            return null;
        }
    }

}
