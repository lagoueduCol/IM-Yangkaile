package com.keller.im.core.po.message;


import com.keller.im.core.mybatis.BaseEntity;
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
     private Long id;
     /**
     * 服务名称
     */
     private String serverName;
     /**
     * 服务IP
     */
     private String serverIp;
     /**
     * 接收方ID
     */
     private Long toId;
     /**
     * 消息类型
     */
     private Integer type;
     /**
     * 消息内容
     */
     private String content;
     /**
     * 状态
     */
     private Integer status;
     /**
     * 接收方式
     */
     private Integer receiveWay;
     /**
     * 创建时间
     */
     private Long createTime;
     /**
     * 发送时间
     */
     private Long updateTime;


  }
