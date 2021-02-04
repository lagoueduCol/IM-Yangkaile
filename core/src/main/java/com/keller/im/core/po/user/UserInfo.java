package com.keller.im.core.po.user;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.TableAttribute;
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
     private Long id;
     /**
     * 昵称
     */
     private String nickName;
     /**
     * 性别
     */
     private Integer gender;
     /**
     * 头像
     */
     private String avatar;
     /**
     * 头像缩略图
     */
     private String avatarThum;
     /**
     * 个人掩码
     */
     private Long mask;
     /**
     * 名片上展示的邮箱
     */
     private String mail;
     /**
     * 名片上展示的手机号
     */
     private String phoneNo;
     /**
     * 个性签名
     */
     private String signature;
     /**
     * 生日
     */
     private Long birthday;
     /**
     * 住址
     */
     private String address;
     /**
     * 注册时间
     */
     private Long registerTime;
     /**
     * 免打扰开始时间
     */
     private Integer noNotifyStart;
     /**
     * 免打扰结束时间
     */
     private Integer noNotifyEnd;
     /**
     * 修改时间
     */
     private Long updateTime;
     /**
     * 版本号
     */
     private Integer version;


  }
