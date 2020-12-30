package com.keller.generator.beetl;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 类型转换器
 * @author yangkaile
 * @date 2020-11-04 14:16:11
 */
public class TypeConverter {
    /**
     * MySql类型到Java类型的转换
     */
    private static Map<String,String> mysql2javaConverterMap = new HashMap<>();


    static {
        mysql2javaConverterMap.put("varchar","String");
        mysql2javaConverterMap.put("tinyint","Integer");
        mysql2javaConverterMap.put("int","Integer");
        mysql2javaConverterMap.put("bigint","Long");
    }

    /**
     * 获取Java类型
     * @param mySqlType
     * @return
     */
    public static String getJavaType(String mySqlType){
        if(StringUtils.isEmpty(mySqlType)){
            return null;
        }
        int index = mySqlType.indexOf("(");
        if(index != -1){
            mySqlType = mySqlType.substring(0,index);
        }
        return mysql2javaConverterMap.get(mySqlType);
    }

    public static void main(String[] args) {
        String javaType = getJavaType("varchar(200)");
        System.out.println(javaType);
        //com.yangkaile.generator  /Users/yangkaile/MyProject/generator/src/main/java/com/yangkaile/generator

        String rootPath = "/Users/yangkaile/MyProject/generator/src/main/java/com/yangkaile/generator";
        String packageName = rootPath.substring(rootPath.indexOf("java/") + 5,rootPath.length()).replace("/",".");
        System.out.println(packageName);
    }

}
