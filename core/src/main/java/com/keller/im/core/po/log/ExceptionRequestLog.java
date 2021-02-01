package com.keller.im.core.po.log;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.FieldAttribute;
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
     @FieldAttribute
     private Long id;
     /**
     * 请求者IP
     */
     @FieldAttribute
     private String ip;
     /**
     * 用户ID
     */
     @FieldAttribute
     private Long userId;
     /**
     * 请求的URL
     */
     @FieldAttribute
     private String url;
     /**
     * 请求类型
     */
     @FieldAttribute
     private Integer type;
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
     * 记录的服务名
     */
     @FieldAttribute
     private String writeServerName;
     /**
     * 记录的IP
     */
     @FieldAttribute
     private String writeIp;


  }
