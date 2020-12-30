package com.keller.core.po.message;


import com.keller.core.mybatis.BaseEntity;
import com.keller.core.mybatis.annotation.FieldAttribute;
import com.keller.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 11:04:15
 */
@Data
@TableAttribute(name = "group_message_info")
public class GroupMessageInfo extends BaseEntity{
     /**
     * ID
     */
     @FieldAttribute
     private Long id;
     /**
     * 群ID
     */
     @FieldAttribute
     private Long groupId;
     /**
     * 群成员ID
     */
     @FieldAttribute
     private Long memberId;
     /**
     * 用户ID
     */
     @FieldAttribute
     private Long userId;
     /**
     * 要提醒的成员ID
     */
     @FieldAttribute
     private String notityMemberIds;
     /**
     * 消息类型
     */
     @FieldAttribute
     private Integer type;
     /**
     * 消息状态
     */
     @FieldAttribute
     private Integer status;
     /**
     * 消息内容
     */
     @FieldAttribute
     private String content;
     /**
     * 序号
     */
     @FieldAttribute
     private Integer index;
     /**
     * 创建时间
     */
     @FieldAttribute
     private Long createTime;


  }
