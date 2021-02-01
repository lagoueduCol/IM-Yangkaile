package com.keller.im.core.po.group;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.FieldAttribute;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 11:02:19
 */
@Data
@TableAttribute(name = "group_member_info")
public class GroupMemberInfo extends BaseEntity{
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
     * 用户ID
     */
     @FieldAttribute
     private Long userId;
     /**
     * 群成员昵称
     */
     @FieldAttribute
     private String nickName;
     /**
     * 群成员类型
     */
     @FieldAttribute
     private Integer type;
     /**
     * 群设置
     */
     @FieldAttribute
     private Long mask;
     /**
     * 消息索引
     */
     @FieldAttribute
     private Integer messageIndex;
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
     /**
     * 修改人
     */
     @FieldAttribute
     private Long updateId;
     /**
     * 版本号
     */
     @FieldAttribute
     private Integer version;


  }
