package com.keller.im.core.mybatis.provider;

import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.util.Console;
import com.keller.im.core.util.ObjectUtils;
import com.keller.im.core.util.StringUtils;
import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.SqlFieldReader;
import com.keller.im.core.util.Console;
import com.keller.im.core.util.ObjectUtils;
import com.keller.im.core.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yangkaile on 2019/7/12.
 */
public class BaseInsertProvider {
    /**
     * 缓存insert语句
     */
    public static Map<String,String> insertMap = new ConcurrentHashMap<>(16);

    public static Map<String,String> insertAndReturnKeyMap = new ConcurrentHashMap<>(16);

    /**
     * 基础的添加语句
     * 读取对象的所有字段属性，生成insert语句
     * @param entity
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> String insert(T entity) {
        Class cls = entity.getClass();
        String className = cls.getName();
        String sql = insertMap.get(className);
        if(ObjectUtils.isEmpty(sql)){
            List<String> fieldList = SqlFieldReader.getFields(entity);

            StringBuilder builder = new StringBuilder();
            builder.append("INSERT INTO ")
                    .append(SqlFieldReader.getTableName(entity)).append(" ")
                    .append("(")
                    .append(StringUtils.humpToLine(SqlFieldReader.getFieldStr(entity)))
                    .append(") ").append("VALUES(");

            StringBuilder valuesStr = new StringBuilder();
            for(String str:fieldList){
                valuesStr.append("#{").append(str).append("}").append(",");
            }
            builder.append(valuesStr.substring(0,valuesStr.length() - 1))
                    .append(") ");
            sql = builder.toString();
            insertMap.put(className,sql);
        }
        Console.info("insert",sql,entity);
        return sql;
    }


    public static void main(String[] args){

    }
}
