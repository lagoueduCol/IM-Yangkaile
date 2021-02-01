package com.keller.im.core.auth;

import lombok.Data;


/**
 * Jwt实体类
 * @author yangkaile
 * @date 2020-12-11 22:21:49
 */
@Data
public class JwtEntity {
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 角色
     */
    private String role;

    /**
     * 类型
     */
    private String type;

    /**
     * 附加码
     */
    private String code;
}
