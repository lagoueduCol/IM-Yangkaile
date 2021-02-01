package com.keller.im.core.mapper.log;

import com.keller.im.core.po.log.ExceptionRequestLog;
import com.keller.im.core.mybatis.BaseMapper;
import com.keller.im.core.po.log.ExceptionRequestLog;
import org.apache.ibatis.annotations.*;

/**
 *  ExceptionRequestLogMapper接口
 * @author yangkaile
 * @date 2020-12-25 11:00:54
 */
@Mapper
public interface ExceptionRequestLogMapper extends BaseMapper<ExceptionRequestLog>{

    /**
     *  表名
     */
    String tableName = "exception_request_log";

    /**
     * 表中所有字段
     */
    String fullFields ="id, ip, user_id, url, type, create_time, write_time, write_server_name, write_ip";
}
