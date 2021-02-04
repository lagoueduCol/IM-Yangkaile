package com.keller.im.core.po.message;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 11:03:57
 */
@Data
@TableAttribute(name = "message_info")
public class MessageInfo extends BaseEntity{
     /**
     * ID
     */
     private Long id;
     /**
     * 发送人ID
     */
     private Long fromId;
     /**
     * 接收人ID
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
     * 创建时间
     */
     private Long createTime;
     /**
     * 修改时间
     */
     private Long updateTime;


  }
