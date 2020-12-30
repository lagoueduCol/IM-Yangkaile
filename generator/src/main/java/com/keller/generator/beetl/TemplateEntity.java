package com.keller.generator.beetl;

import com.keller.generator.beetl.entity.TableInfo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Data
@Component
@ConfigurationProperties(prefix = "keller")
public class TemplateEntity {
    /**
     * 文件路径
     */
    private String  path;
    /**
     * 包名（模块名）
     */

    private String packageName;
    /**
     * 实体类名
     */
    private String entityName;

    private String tableName;



    private List<TableInfo> list;


    /**
     * 模板名称
     *
     */
    private String templateName;


    private String author;



    private String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    private String instanceName;

    private TableInfo keyField;



}
