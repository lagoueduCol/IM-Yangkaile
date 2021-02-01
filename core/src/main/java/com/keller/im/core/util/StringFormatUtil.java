package com.keller.im.core.util;

import com.keller.im.core.enums.UserNameTypeEnums;

import java.util.regex.Pattern;

/**
 * 字符串格式工具类
 * @author yangkaile
 * @date 2021-01-23 17:53:51
 */
public class StringFormatUtil {

    /**
     * 用户名 4到20位字母、数字、下划线的组合，不能以数字开头
     */
    public static final String userNameFormat = "^[^0-9][\\w_]{3,19}$";

    /**
     * 邮箱
     */
    public static final String emailFormat = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * 手机号，11位数字，必须是1开头
     */
    public static final String phoneFormat = "^1\\d{10}$";


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

    public static void main(String[] args) {
        System.out.println(matchesUserNameType("16619926850"));
        System.out.println(matchesUserNameType("guyexing@foxmail.com"));
        System.out.println(matchesUserNameType("NickName001"));
        System.out.println(matchesUserNameType("凯乐1001"));
    }

}
