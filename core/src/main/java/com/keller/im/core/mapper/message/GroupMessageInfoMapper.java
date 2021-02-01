package com.keller.im.core.mapper.message;

import com.keller.im.core.mybatis.BaseMapper;
import com.keller.im.core.po.message.GroupMessageInfo;
import org.apache.ibatis.annotations.*;

/**
 *  GroupMessageInfoMapper接口
 * @author yangkaile
 * @date 2020-12-25 11:04:15
 */
@Mapper
public interface GroupMessageInfoMapper extends BaseMapper<GroupMessageInfo>{

    /**
     *  表名
     */
    String tableName = "group_message_info";

    /**
     * 表中所有字段
     */
    String fullFields ="id, group_id, member_id, user_id, notify_member_ids, type, status, content, index, create_time";
}
