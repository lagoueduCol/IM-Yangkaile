package com.keller.im.core.response;


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
    NoParams("100002","缺少必要参数"),

    NoService("100004","没找到相应的服务");

    public String code;
    public String message;

    ServiceResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
