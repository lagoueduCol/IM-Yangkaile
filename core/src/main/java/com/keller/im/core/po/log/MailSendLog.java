package com.keller.im.core.po.log;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.FieldAttribute;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 10:59:33
 */
@Data
@TableAttribute(name = "mail_send_log")
public class MailSendLog extends BaseEntity{
     /**
     * ID
     */
     @FieldAttribute
     private Long id;
     /**
     * 邮件类型
     */
     @FieldAttribute
     private String type;
     /**
     * 发件人
     */
     @FieldAttribute
     private String fromMail;
     /**
     * 收件人
     */
     @FieldAttribute
     private String toMail;
     /**
     * 标题
     */
     @FieldAttribute
     private String title;
     /**
     * 内容
     */
     @FieldAttribute
     private String content;
     /**
     * 验证码
     */
     @FieldAttribute
     private String code;
     /**
     * 验证码状态
     */
     @FieldAttribute
     private String codeStatus;
     /**
     * 发送时间
     */
     @FieldAttribute
     private Long sendTime;

     @FieldAttribute
     private String sendResult;

     @FieldAttribute
     private String sendStatus;

     /**
     * 更新时间
     */
     @FieldAttribute
     private Long updateTime;


  }
