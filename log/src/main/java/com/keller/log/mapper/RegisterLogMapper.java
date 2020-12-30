package com.keller.log.mapper;

import com.keller.core.mybatis.BaseMapper;
import com.keller.core.po.log.RegisterLog;
import org.apache.ibatis.annotations.*;

/**
 *  RegisterLogMapper接口
 * @author yangkaile
 * @date 2020-12-25 10:58:40
 */
@Mapper
public interface RegisterLogMapper extends BaseMapper<RegisterLog>{

    /**
     *  表名
     */
    String tableName = "register_log";

    /**
     * 表中所有字段
     */
    String fullFields ="id, user_id, phone_no, mail, ip, register_time, register_way";
}
