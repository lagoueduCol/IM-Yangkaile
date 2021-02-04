package com.keller.im.core.po.log;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 10:58:21
 */
@Data
@TableAttribute(name = "login_log")
public class LoginLog extends BaseEntity {
     /**
     * ID
     */
     private Long id;
     /**
     * 用户ID
     */
     private Long userId;
     /**
     * IP地址
     */
     private String ip;
     /**
     * 登录时间
     */
     private Long loginTime;
     /**
     * 登录方式
     */
     private Long loginWay;


  }
