package com.keller.im.core.po.user;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.FieldAttribute;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 10:55:58
 */
@Data
@TableAttribute(name = "register_info")
public class RegisterInfo extends BaseEntity{
     /**
     * id
     */
     @FieldAttribute
     private Long id;
     /**
     * 用户名
     */
     @FieldAttribute
     private String userName;
     /**
     * 密码
     */
     @FieldAttribute
     private String password;
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
     * 注册时间
     */
     @FieldAttribute
     private Long registerTime;


  }
