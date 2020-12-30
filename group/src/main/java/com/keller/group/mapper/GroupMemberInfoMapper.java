package com.keller.group.mapper;

import com.keller.core.mybatis.BaseMapper;
import com.keller.core.po.group.GroupMemberInfo;
import org.apache.ibatis.annotations.*;

/**
 *  GroupMemberInfoMapper接口
 * @author yangkaile
 * @date 2020-12-25 11:02:19
 */
@Mapper
public interface GroupMemberInfoMapper extends BaseMapper<GroupMemberInfo>{

    /**
     *  表名
     */
    String tableName = "group_member_info";

    /**
     * 表中所有字段
     */
    String fullFields ="id, group_id, user_id, nick_name, type, mask, message_index, create_time, update_time, update_id, version";
}
