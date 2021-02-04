package com.keller.im.core.po.log;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 11:00:54
 */
@Data
@TableAttribute(name = "exception_request_log")
public class ExceptionRequestLog extends BaseEntity{
     /**
     * ID
     */
     private Long id;
     /**
     * 请求者IP
     */
     private String ip;
     /**
     * 用户ID
     */
     private Long userId;
     /**
     * 请求的URL
     */
     private String url;
     /**
     * 请求类型
     */
     private Integer type;
     /**
     * 发生时间
     */
     private Long createTime;
     /**
     * 记录时间
     */
     private Long writeTime;
     /**
     * 记录的服务名
     */
     private String writeServerName;
     /**
     * 记录的IP
     */
     private String writeIp;


  }
