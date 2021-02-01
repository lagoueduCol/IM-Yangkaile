package com.keller.im.core.mapper.user;

import com.keller.im.core.mybatis.BaseMapper;
import com.keller.im.core.po.user.RegisterInfo;
import org.apache.ibatis.annotations.*;

/**
 *  RegisterInfoMapper接口
 * @author yangkaile
 * @date 2020-12-25 10:55:58
 */
@Mapper
public interface RegisterInfoMapper extends BaseMapper<RegisterInfo>{

    /**
     *  表名
     */
    String tableName = "register_info";

    /**
     * 表中所有字段
     */
    String fullFields ="id, user_name, password, phone_no, mail, register_time";

    String selectPrefix = "SELECT " + fullFields + " FROM " + tableName;

    @Select(selectPrefix + " WHERE user_name = #{userName}")
    RegisterInfo getByUserName(String userName);

    @Select(selectPrefix + " WHERE phone_no = #{phoneNo}")
    RegisterInfo getByPhoneNo(String phoneNo);

    @Select(selectPrefix + " WHERE mail = #{mail}")
    RegisterInfo getByMail(String mail);

}
