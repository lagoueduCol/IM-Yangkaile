package com.keller.im.core.po.message;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.FieldAttribute;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 11:04:49
 */
@Data
@TableAttribute(name = "system_message_info")
public class SystemMessageInfo extends BaseEntity{
     /**
     * ID
     */
     @FieldAttribute
     private Long id;
     /**
     * 服务名称
     */
     @FieldAttribute
     private String serverName;
     /**
     * 服务IP
     */
     @FieldAttribute
     private String serverIp;
     /**
     * 接收方ID
     */
     @FieldAttribute
     private Long toId;
     /**
     * 消息类型
     */
     @FieldAttribute
     private Integer type;
     /**
     * 消息内容
     */
     @FieldAttribute
     private String content;
     /**
     * 状态
     */
     @FieldAttribute
     private Integer status;
     /**
     * 接收方式
     */
     @FieldAttribute
     private Integer receiveWay;
     /**
     * 创建时间
     */
     @FieldAttribute
     private Long createTime;
     /**
     * 发送时间
     */
     @FieldAttribute
     private Long updateTime;


  }
