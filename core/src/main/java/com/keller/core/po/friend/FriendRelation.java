package com.keller.core.po.friend;


import com.keller.core.mybatis.BaseEntity;
import com.keller.core.mybatis.annotation.FieldAttribute;
import com.keller.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 11:03:02
 */
@Data
@TableAttribute(name = "friend_relation")
public class FriendRelation extends BaseEntity{
     /**
     * id
     */
     @FieldAttribute
     private Long id;
     /**
     * 用户ID
     */
     @FieldAttribute
     private Long userId;
     /**
     * 好友ID
     */
     @FieldAttribute
     private Long friendId;
     /**
     * 好友备注名
     */
     @FieldAttribute
     private String remark;
     /**
     * 好友设置
     */
     @FieldAttribute
     private Long mask;
     /**
     * 好友状态
     */
     @FieldAttribute
     private Integer status;
     /**
     * 创建时间
     */
     @FieldAttribute
     private Long createTime;
     /**
     * 最后一次修改时间
     */
     @FieldAttribute
     private Long updateTime;
     /**
     * 版本号
     */
     @FieldAttribute
     private Integer version;


  }
