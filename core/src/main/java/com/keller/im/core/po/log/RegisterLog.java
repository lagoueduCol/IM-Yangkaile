package com.keller.im.core.po.log;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 10:58:40
 */
@Data
@TableAttribute(name = "register_log")
public class RegisterLog extends BaseEntity {
     /**
     * ID
     */
     private Long id;
     /**
     * 用户ID
     */
     private Long userId;
     /**
     * 手机号
     */
     private String phoneNo;
     /**
     * 邮箱
     */
     private String mail;
     /**
     * IP地址
     */
     private String ip;
     /**
     * 注册时间
     */
     private Long registerTime;
     /**
     * 注册方式
     */
     private Integer registerWay;


  }
