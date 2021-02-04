package com.keller.im.core.po.group;


import com.keller.im.core.mybatis.BaseEntity;
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
     private Long id;
     /**
     * 群ID
     */
     private Long groupId;
     /**
     * 用户ID
     */
     private Long userId;
     /**
     * 群成员昵称
     */
     private String nickName;
     /**
     * 群成员类型
     */
     private Integer type;
     /**
     * 群设置
     */
     private Long mask;
     /**
     * 消息索引
     */
     private Integer messageIndex;
     /**
     * 创建时间
     */
     private Long createTime;
     /**
     * 修改时间
     */
     private Long updateTime;
     /**
     * 修改人
     */
     private Long updateId;
     /**
     * 版本号
     */
     private Integer version;


  }
