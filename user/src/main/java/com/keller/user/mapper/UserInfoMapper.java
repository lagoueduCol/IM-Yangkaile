package com.keller.user.mapper;

import com.keller.core.mybatis.BaseMapper;
import com.keller.core.po.user.UserInfo;
import org.apache.ibatis.annotations.*;

/**
 *  UserInfoMapper接口
 * @author yangkaile
 * @date 2020-12-25 10:57:08
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo>{

    /**
     *  表名
     */
    String tableName = "user_info";

    /**
     * 表中所有字段
     */
    String fullFields ="id, nick_name, gender, avatar, avatar_thum, mask, mail, phone_no, signature, birthday, address, register_time, no_notify_start, no_notify_end, update_time, version";
}
