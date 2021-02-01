package com.keller.im.core.mapper.log;

import com.keller.im.core.mybatis.BaseMapper;
import com.keller.im.core.po.log.SystemLog;
import org.apache.ibatis.annotations.*;

/**
 *  SystemLogMapper接口
 * @author yangkaile
 * @date 2020-12-25 10:59:11
 */
@Mapper
public interface SystemLogMapper extends BaseMapper<SystemLog>{

    /**
     *  表名
     */
    String tableName = "system_log";

    /**
     * 表中所有字段
     */
    String fullFields ="id, server_name, class_name, method_name, ip, port, type, content, create_time, write_time, write_server_name, write_ip";
}
