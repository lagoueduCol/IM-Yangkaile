package com.keller.im.core.po.group;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.TableAttribute;
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
     private Long id;
     /**
     * 群名称
     */
     private String name;
     /**
     * 群公告
     */
     private String notice;
     /**
     * 群主ID
     */
     private Long ownerId;
     /**
     * 群成员人数
     */
     private Integer size;
     /**
     * 群消息索引值
     */
     private Integer messageIndex;
     /**
     * 创建时间
     */
     private Long createTime;
     /**
     * 创建人
     */
     private Long createId;
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
