package com.keller.im.core.mapper.message;

import com.keller.im.core.mybatis.BaseMapper;
import com.keller.im.core.po.message.MessageInfo;
import org.apache.ibatis.annotations.*;

/**
 *  MessageInfoMapper接口
 * @author yangkaile
 * @date 2020-12-25 11:03:57
 */
@Mapper
public interface MessageInfoMapper extends BaseMapper<MessageInfo>{

    /**
     *  表名
     */
    String tableName = "message_info";

    /**
     * 表中所有字段
     */
    String fullFields ="id, from_id, to_id, type, content, status, create_time, update_time";
}
