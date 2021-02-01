package com.keller.im.core.mapper.log;

import com.keller.im.core.po.log.MailSendLog;
import com.keller.im.core.mybatis.BaseMapper;
import com.keller.im.core.po.log.MailSendLog;
import org.apache.ibatis.annotations.*;

/**
 *  MailSendLogMapper接口
 * @author yangkaile
 * @date 2020-12-25 10:59:33
 */
@Mapper
public interface MailSendLogMapper extends BaseMapper<MailSendLog>{

    /**
     *  表名
     */
    String tableName = "mail_send_log";

    /**
     * 表中所有字段
     */
    String fullFields ="id, type, from_mail, to_mail, title, content, code, code_status, send_time, update_time";

//    @Select({
//            "SELECT ",fullFields," FROM ",tableName," WHERE code_status = 'Available'"
//    })
}
