package com.keller.im.core.po.message;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.TableAttribute;
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
     private Long id;
     /**
     * 群ID
     */
     private Long groupId;
     /**
     * 群成员ID
     */
     private Long memberId;
     /**
     * 用户ID
     */
     private Long userId;
     /**
     * 要提醒的成员ID
     */
     private String notifyMemberIds;
     /**
     * 消息类型
     */
     private Integer type;
     /**
     * 消息状态
     */
     private Integer status;
     /**
     * 消息内容
     */
     private String content;
     /**
     * 序号
     */
     private Integer index;
     /**
     * 创建时间
     */
     private Long createTime;


  }
