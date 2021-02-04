package com.keller.im.core.po.log;


import com.keller.im.core.mybatis.BaseEntity;
import com.keller.im.core.mybatis.annotation.TableAttribute;
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
     private Long id;
     /**
     * 用户ID
     */
     private Long userId;
     /**
     * 原文件名
     */
     private String originFileName;
     /**
     * 文件名
     */
     private String fileName;
     /**
     * 文件类型
     */
     private String fileType;
     /**
     * 文件大小 KB
     */
     private Long size;
     /**
     * URL
     */
     private String url;
     /**
     * 视频封面URL
     */
     private String coverUrl;
     /**
     * 压缩后的文件URL
     */
     private String thumUrl;
     /**
     * 音视频文件时长
     */
     private Integer duration;
     /**
     * 上传时间
     */
     private Long createTime;
     /**
     * 上传完成时间
     */
     private Long finishTime;


  }
