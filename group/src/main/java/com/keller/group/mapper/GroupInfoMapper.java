package com.keller.group.mapper;

import com.keller.core.mybatis.BaseMapper;
import com.keller.core.po.group.GroupInfo;
import org.apache.ibatis.annotations.*;

/**
 *  GroupInfoMapper接口
 * @author yangkaile
 * @date 2020-12-25 11:02:00
 */
@Mapper
public interface GroupInfoMapper extends BaseMapper<GroupInfo>{

    /**
     *  表名
     */
    String tableName = "group_info";

    /**
     * 表中所有字段
     */
    String fullFields ="id, name, notice, owner_id, size, message_index, create_time, create_id, update_time, update_id, version";
}
