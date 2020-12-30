package com.keller.friend.mapper;

import com.keller.core.mybatis.BaseMapper;
import com.keller.core.po.friend.FriendRelation;
import org.apache.ibatis.annotations.*;

/**
 *  FriendRelationMapper接口
 * @author yangkaile
 * @date 2020-12-25 11:03:02
 */
@Mapper
public interface FriendRelationMapper extends BaseMapper<FriendRelation>{

    /**
     *  表名
     */
    String tableName = "friend_relation";

    /**
     * 表中所有字段
     */
    String fullFields ="id, user_id, friend_id, remark, mask, status, create_time, update_time, version";
}
