package com.keller.message.mapper;

import com.keller.core.mybatis.BaseMapper;
import com.keller.core.po.message.SystemMessageInfo;
import org.apache.ibatis.annotations.*;

/**
 *  SystemMessageInfoMapper接口
 * @author yangkaile
 * @date 2020-12-25 11:04:49
 */
@Mapper
public interface SystemMessageInfoMapper extends BaseMapper<SystemMessageInfo>{

    /**
     *  表名
     */
    String tableName = "system_message_info";

    /**
     * 表中所有字段
     */
    String fullFields ="id, server_name, server_ip, to_id, type, content, status, receive_way, create_time, update_time";
}
