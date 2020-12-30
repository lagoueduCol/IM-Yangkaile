package com.keller.core.auth;

import lombok.Data;


/**
 * Jwt实体类
 * @author yangkaile
 * @date 2020-12-11 22:21:49
 */
@Data
public class JwtEntity {
    private Integer userId;

    private String role;

    private String type;

    private String code;
}
