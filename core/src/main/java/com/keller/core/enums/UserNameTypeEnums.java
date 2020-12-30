package com.keller.core.enums;

/**
 * 用来登录的用户名类型
 * @author yangkaile
 * @date 2020-12-17 08:30:22
 */
public enum UserNameTypeEnums {
    /**
     * 用户名
     */
    UserName(1,"UserName"),
    /**
     * 邮箱
     */
    Mail(2,"Mail"),
    /**
     * 手机号
     */
    Phone(3,"Phone");
    public Integer value;
    public String name;

    UserNameTypeEnums(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
