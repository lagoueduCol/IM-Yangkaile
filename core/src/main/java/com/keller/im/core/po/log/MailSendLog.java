package com.keller.im.core.po.log;


import com.keller.im.core.mybatis.BaseEntity;
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
     private Long id;
     /**
     * 邮件类型
     */
     private String type;
     /**
     * 发件人
     */
     private String fromMail;
     /**
     * 收件人
     */
     private String toMail;
     /**
     * 标题
     */
     private String title;
     /**
     * 内容
     */
     private String content;
     /**
     * 验证码
     */
     private String code;
     /**
     * 验证码状态
     */
     private String codeStatus;
     /**
     * 发送时间
     */
     private Long sendTime;

     /**
      * 发送结果，如果失败，记录失败原因
      */
     private String sendResult;

     /**
      * 发送状态
      */
     private String sendStatus;

     /**
     * 更新时间
     */
     private Long updateTime;


  }
