package com.keller.core.mybatis;


import com.keller.core.mybatis.annotation.*;
import com.keller.core.util.ObjectUtils;
import com.keller.core.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Provider工具类
 * 提供获取读取表名、字段名等公用方法
 *
 * @author yangkaile
 * @date 2019-09-12 15:29:19
 */
public class SqlFieldReader {

    public static ConcurrentHashMap<String, String> tableNameMap = new ConcurrentHashMap<>(16);

    /**
     * 读取表名，要求类上有@TableAttribute注解
     *
     * @param entity 实体对象
     * @return tableName
     */
    public static <T extends BaseEntity> String getTableName(T entity) {
        Class cls = entity.getClass();
        String tableName = tableNameMap.get(cls.getName());
        if (ObjectUtils.noEmpty(tableName)) {
            return tableName;
        }
        TableAttribute table = entity.getClass().getAnnotation(TableAttribute.class);
        if (table == null) {
            throw new BaseException("需要解析表名，但未找到@TableAttribute注解");
        }
        tableNameMap.put(cls.getName(), table.name());
        return table.name();
    }

    /**
     * 生成查询条件
     * @param entity 实体对象
     * @param <T>    实体类型
     * @return WHERE name = #{name} OR controllerName = #{controllerName}
     */
    public static <T extends BaseEntity> String getConditionSuffix(T entity) {
        //如果设置了自定义的查询条件，返回自定义查询条件，不再判断字段值
        if (ObjectUtils.noEmpty(entity.getBaseCondition())) {
            return entity.getBaseCondition();
        }
        return "";
    }

    /**
     * 获取排序条件
     *
     * @param entity
     * @param <T>
     * @return
     */
//    public static <T extends BaseEntity> String getSortSuffix(T entity) {
//        String condition;
//        if (entity.getBaseAsc() == null) {
//            return "";
//        }
//        if (entity.getBaseAsc()) {
//            condition = "ASC";
//        } else {
//            condition = "DESC";
//        }
//        Class cls = entity.getClass();
//        Field[] fields = cls.getDeclaredFields();
//        StringBuilder builder = new StringBuilder();
//        builder.append(" ORDER BY ");
//        try {
//            for (Field field : fields) {
//                if (field.getAnnotation(SortAttribute.class) != null) {
//                    builder.append(field.getName()).append(" ")
//                            .append(condition).append(",");
//
//                }
//            }
//            int index = builder.lastIndexOf(",");
//            if (index < 0) {
//                return "";
//            }
//            return builder.substring(0, index);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

    /**
     * 获取所有字段列表
     * 读取类中带@FieldAttribute注解的字段，如果都没有带该注解，则返回类中所有字段
     *
     * @return {id,name}
     */
    public static <T extends BaseEntity> List<String> getFields(T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        List<String> fieldList = new ArrayList<>();
        List<String> allList = new ArrayList<>();
        //带@FieldAttribute注解的属性名
        for (Field field : fields) {
            allList.add(field.getName());
            if (field.getAnnotation(FieldAttribute.class) != null) {
                fieldList.add(field.getName());
            }
        }
        if (fieldList.size() == 0) {
            return allList;
        }
        return fieldList;
    }
    /**
     * 将所有字段名以逗号拼接起来返回
     * 从属性前的@FieldAttribute注解解析要查询的字段名
     * 当所有属性都没有@FieldAttribute注解时，解析所有属性名作为字段名
     *
     * @param entity 实体对象
     * @return id, name
     */
    public static <T extends BaseEntity> String getFieldStr(T entity) {
        List<String> list = getFields(entity);
        if (list == null || list.isEmpty()){
            return "";
        }
        return String.join(",",list);
    }

    /**
     * 判断一个对象的指定字段有没有值
     *
     * @param entity    实体对象
     * @param fieldName 对象的字段名
     * @param <T>       实体类型
     * @return 值存在且不为null:返回true; 否则:返回false
     */
    public static <T extends BaseEntity> boolean hasValue(T entity, String fieldName) {
        try {
            Class cls = entity.getClass();
            Method method = cls.getMethod("get" + StringUtils.captureName(fieldName));
            if (method.invoke(entity) == null) {
                return false;
            } else {
                return true;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }
}
