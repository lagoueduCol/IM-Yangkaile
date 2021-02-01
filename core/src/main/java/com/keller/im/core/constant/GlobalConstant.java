package com.keller.im.core.constant;

/**
 * 全局常量
 * @author yangkaile
 * @date 2020-12-11 22:02:18
 */
public class GlobalConstant {

    /**
     * 应用名
     */
    public static final String APPLICATION_NAME = "Keller_IM";

    /**
     * 应用访问地址
     */
    public static final String APPLICATION_URL = "";


    /**
     * Token有效期,毫秒，默认为12小时
     */
    public static final Long TOKEN_EXPIRATION_TIME = 12*3600*1000L;

    /**
     * Token签名
     */
    public static final String TOKEN_SIGN_KEY = "Keller_2020-12-11_BeiJing";


    /**
     * 邮件验证码有效时间，分钟
     */
    public static final Integer EMAIL_CODE_EXPIRATION_TIME = 5;


    /**
     * 邮件验证码长度
     */
    public static final Integer EMAIL_CODE_LENGTH = 8;





}
