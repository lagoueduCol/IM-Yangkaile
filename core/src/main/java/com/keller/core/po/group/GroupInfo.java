package com.keller.core.po.group;


import com.keller.core.mybatis.BaseEntity;
import com.keller.core.mybatis.annotation.FieldAttribute;
import com.keller.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 11:02:00
 */
@Data
@TableAttribute(name = "group_info")
public class GroupInfo extends BaseEntity{
     /**
     * ID
     */
     @FieldAttribute
     private Long id;
     /**
     * 群名称
     */
     @FieldAttribute
     private String name;
     /**
     * 群公告
     */
     @FieldAttribute
     private String notice;
     /**
     * 群主ID
     */
     @FieldAttribute
     private Long ownerId;
     /**
     * 群成员人数
     */
     @FieldAttribute
     private Integer size;
     /**
     * 群消息索引值
     */
     @FieldAttribute
     private Integer messageIndex;
     /**
     * 创建时间
     */
     @FieldAttribute
     private Long createTime;
     /**
     * 创建人
     */
     @FieldAttribute
     private Long createId;
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
