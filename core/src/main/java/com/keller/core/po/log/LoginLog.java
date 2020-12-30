package com.keller.core.po.log;


import com.keller.core.mybatis.BaseEntity;
import com.keller.core.mybatis.annotation.FieldAttribute;
import com.keller.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 10:58:21
 */
@Data
@TableAttribute(name = "login_log")
public class LoginLog extends BaseEntity{
     /**
     * ID
     */
     @FieldAttribute
     private Long id;
     /**
     * 用户ID
     */
     @FieldAttribute
     private Long userId;
     /**
     * IP地址
     */
     @FieldAttribute
     private String ip;
     /**
     * 登录时间
     */
     @FieldAttribute
     private Long loginTime;
     /**
     * 登录方式
     */
     @FieldAttribute
     private Long loginWay;


  }
