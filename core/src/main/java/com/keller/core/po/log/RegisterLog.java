package com.keller.core.po.log;


import com.keller.core.mybatis.BaseEntity;
import com.keller.core.mybatis.annotation.FieldAttribute;
import com.keller.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 10:58:40
 */
@Data
@TableAttribute(name = "register_log")
public class RegisterLog extends BaseEntity{
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
     * 手机号
     */
     @FieldAttribute
     private String phoneNo;
     /**
     * 邮箱
     */
     @FieldAttribute
     private String mail;
     /**
     * IP地址
     */
     @FieldAttribute
     private String ip;
     /**
     * 注册时间
     */
     @FieldAttribute
     private Long registerTime;
     /**
     * 注册方式
     */
     @FieldAttribute
     private Integer registerWay;


  }
