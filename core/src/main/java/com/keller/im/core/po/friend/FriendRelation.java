package com.keller.im.core.po.friend;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.TableAttribute;
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
     private Long id;
     /**
     * 用户ID
     */
     private Long userId;
     /**
     * 好友ID
     */
     private Long friendId;
     /**
     * 好友备注名
     */
     private String remark;
     /**
     * 好友设置
     */
     private Long mask;
     /**
     * 好友状态
     */
     private Integer status;
     /**
     * 创建时间
     */
     private Long createTime;
     /**
     * 最后一次修改时间
     */
     private Long updateTime;
     /**
     * 版本号
     */
     private Integer version;


  }
