package com.keller.core.po.log;


import com.keller.core.mybatis.BaseEntity;
import com.keller.core.mybatis.annotation.FieldAttribute;
import com.keller.core.mybatis.annotation.TableAttribute;
import lombok.Data;


/**
 *
 * @author yangkaile
 * @date 2020-12-25 11:00:23
 */
@Data
@TableAttribute(name = "file_upload_log")
public class FileUploadLog extends BaseEntity{
     /**
     * ID
     */
     @FieldAttribute
     private Long id;
     /**
     * 用户ID
     */
     @FieldAttribute
     private Long userId;
     /**
     * 原文件名
     */
     @FieldAttribute
     private String originFileName;
     /**
     * 文件名
     */
     @FieldAttribute
     private String fileName;
     /**
     * 文件类型
     */
     @FieldAttribute
     private String fileType;
     /**
     * 文件大小 KB
     */
     @FieldAttribute
     private Long size;
     /**
     * URL
     */
     @FieldAttribute
     private String url;
     /**
     * 视频封面URL
     */
     @FieldAttribute
     private String coverUrl;
     /**
     * 压缩后的文件URL
     */
     @FieldAttribute
     private String thumUrl;
     /**
     * 音视频文件时长
     */
     @FieldAttribute
     private Integer duration;
     /**
     * 上传时间
     */
     @FieldAttribute
     private Long createTime;
     /**
     * 上传完成时间
     */
     @FieldAttribute
     private Long finishTime;


  }
