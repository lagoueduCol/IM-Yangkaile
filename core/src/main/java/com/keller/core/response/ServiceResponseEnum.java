package com.keller.core.response;


public enum ServiceResponseEnum {
    /**
     * 业务处理成功
     */
    Success("000000","处理成功"),
    /**
     * 没有ID
     */
    NoId("100001","缺少ID"),
    /**
     * 缺少必要参数
     */
    NoParams("100002","缺少必要参数");

    public String code;
    public String message;

    ServiceResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
