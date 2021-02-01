package com.keller.im.core.mapper.log;

import com.keller.im.core.po.log.FileUploadLog;
import com.keller.im.core.mybatis.BaseMapper;
import com.keller.im.core.po.log.FileUploadLog;
import org.apache.ibatis.annotations.*;

/**
 *  FileUploadLogMapper接口
 * @author yangkaile
 * @date 2020-12-25 11:00:23
 */
@Mapper
public interface FileUploadLogMapper extends BaseMapper<FileUploadLog>{

    /**
     *  表名
     */
    String tableName = "file_upload_log";

    /**
     * 表中所有字段
     */
    String fullFields ="id, user_id, origin_file_name, file_name, file_type, size, url, cover_url, thum_url, duration, create_time, finish_time";
}
