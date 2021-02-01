package com.keller.im.core.po.log;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.FieldAttribute;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.FieldAttribute;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 10:59:11
 */
@Data
@TableAttribute(name = "system_log")
public class SystemLog extends BaseEntity {
     /**
     * ID
     */
     @FieldAttribute
     private Long id;
     /**
     * 服务名
     */
     @FieldAttribute
     private String serverName;
     /**
     * 类名
     */
     @FieldAttribute
     private String className;
     /**
     * 方法名
     */
     @FieldAttribute
     private String methodName;
     /**
     * IP
     */
     @FieldAttribute
     private String ip;
     /**
     * 端口号
     */
     @FieldAttribute
     private String port;
     /**
     * 日志类型
     */
     @FieldAttribute
     private Long type;
     /**
     * 日志内容
     */
     @FieldAttribute
     private String content;
     /**
     * 发生时间
     */
     @FieldAttribute
     private Long createTime;
     /**
     * 记录时间
     */
     @FieldAttribute
     private Long writeTime;
     /**
     * 记录日志的服务名
     */
     @FieldAttribute
     private String writeServerName;
     /**
     * 记录日志的IP
     */
     @FieldAttribute
     private String writeIp;


  }
