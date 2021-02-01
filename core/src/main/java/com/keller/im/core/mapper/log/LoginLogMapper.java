package com.keller.im.core.mapper.log;

import com.keller.im.core.mybatis.BaseMapper;
import com.keller.im.core.mybatis.BaseMapper;
import com.keller.im.core.po.log.LoginLog;
import org.apache.ibatis.annotations.*;

/**
 *  LoginLogMapper接口
 * @author yangkaile
 * @date 2020-12-25 10:58:21
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {

    /**
     *  表名
     */
    String tableName = "login_log";

    /**
     * 表中所有字段
     */
    String fullFields ="id, user_id, ip, login_time, login_way";
}
