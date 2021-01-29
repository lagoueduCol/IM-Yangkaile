package com.keller.user.vo;

import lombok.Data;

/**
 * @author yangkaile
 * @date 2021-01-23 13:42:39
 */
@Data
public class LoginVo {

    /**
     * 用户名
     */
    private String name;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 验证码
     */
    private String code;

    /**
     * 密码
     */
    private String password;
}
