package com.keller.core.enums;

/**
 * RequestHeader枚举
 * @author yangkaile
 * @date 2020-12-11 18:35:05
 */
public enum RequestHeaderEnums {

    /**
     * Token
     */
    Token("token","token");
    public String name;
    public String description;

    RequestHeaderEnums(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
