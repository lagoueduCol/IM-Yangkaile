package com.keller.core.po.user;


import com.keller.core.mybatis.BaseEntity;
import com.keller.core.mybatis.annotation.FieldAttribute;
import com.keller.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 10:57:08
 */
@Data
@TableAttribute(name = "user_info")
public class UserInfo extends BaseEntity{
     /**
     * ID
     */
     @FieldAttribute
     private Long id;
     /**
     * 昵称
     */
     @FieldAttribute
     private String nickName;
     /**
     * 性别
     */
     @FieldAttribute
     private Integer gender;
     /**
     * 头像
     */
     @FieldAttribute
     private String avatar;
     /**
     * 头像缩略图
     */
     @FieldAttribute
     private String avatarThum;
     /**
     * 个人掩码
     */
     @FieldAttribute
     private Long mask;
     /**
     * 名片上展示的邮箱
     */
     @FieldAttribute
     private String mail;
     /**
     * 名片上展示的手机号
     */
     @FieldAttribute
     private String phoneNo;
     /**
     * 个性签名
     */
     @FieldAttribute
     private String signature;
     /**
     * 生日
     */
     @FieldAttribute
     private Long birthday;
     /**
     * 住址
     */
     @FieldAttribute
     private String address;
     /**
     * 注册时间
     */
     @FieldAttribute
     private Long registerTime;
     /**
     * 免打扰开始时间
     */
     @FieldAttribute
     private Integer noNotifyStart;
     /**
     * 免打扰结束时间
     */
     @FieldAttribute
     private Integer noNotifyEnd;
     /**
     * 修改时间
     */
     @FieldAttribute
     private Long updateTime;
     /**
     * 版本号
     */
     @FieldAttribute
     private Integer version;


  }
