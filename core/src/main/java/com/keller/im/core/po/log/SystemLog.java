package com.keller.im.core.po.log;


import com.keller.im.core.mybatis.BaseEntity;
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
     private Long id;
     /**
     * 服务名
     */
     private String serverName;
     /**
     * 类名
     */
     private String className;
     /**
     * 方法名
     */
     private String methodName;
     /**
     * IP
     */
     private String ip;
     /**
     * 端口号
     */
     private String port;
     /**
     * 日志类型
     */
     private Long type;
     /**
     * 日志内容
     */
     private String content;
     /**
     * 发生时间
     */
     private Long createTime;
     /**
     * 记录时间
     */
     private Long writeTime;
     /**
     * 记录日志的服务名
     */
     private String writeServerName;
     /**
     * 记录日志的IP
     */
     private String writeIp;


  }
