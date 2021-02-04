package com.keller.im.core.response;

/**
 *
 * @author yangkaile
 * @date 2021-02-02 07:38:03
 */
public enum ServiceResponseEnum {
    /**
     * 000000 表示业务处理成功
     */
    Success("000000","处理成功"),
    /**
     * 10开头的是通用错误码
     */
    CommonNoId("100001","缺少ID"),
    CommonNoParams("100002","缺少必要参数"),
    CommonErrorParams("10003","参数不正确"),
    CommonNoService("100004","没找到相应的服务"),
    CommonNoFunction("100005","暂不支持该功能"),
    /**
     * 20开头的是用户相关错误码
     */
    UserUserNameNotAvailable("200001","用户名不可用");


    public String code;
    public String message;

    ServiceResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
