package com.keller.core.po.message;


import com.keller.core.mybatis.BaseEntity;
import com.keller.core.mybatis.annotation.FieldAttribute;
import com.keller.core.mybatis.annotation.TableAttribute;
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
     @FieldAttribute
     private Long id;
     /**
     * 发送人ID
     */
     @FieldAttribute
     private Long fromId;
     /**
     * 接收人ID
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
     * 创建时间
     */
     @FieldAttribute
     private Long createTime;
     /**
     * 修改时间
     */
     @FieldAttribute
     private Long updateTime;


  }
