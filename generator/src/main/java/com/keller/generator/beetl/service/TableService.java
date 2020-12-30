package com.keller.generator.beetl.service;

import com.keller.generator.beetl.TemplateEntity;
import com.keller.generator.beetl.TypeConverter;
import com.keller.generator.beetl.entity.TableInfo;
import com.keller.generator.beetl.mapper.TableMapper;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.FileResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 核心逻辑
 * @author yangkaile
 * @date 2020-11-13 17:48:16
 */
@Service
public class TableService {


    /**
     * 文件分隔符，用于匹配不同文件系统（主要是Windows和MacOS、Linux）的差异
     */
    public static String separator = File.separator;

    /**
     * mapper，用于执行数据库操作，获取表结构信息
     */
    @Resource
    private TableMapper mapper;


    /**
     * 读取配置文件
     */
    @Resource
    private TemplateEntity templateEntity;

    /**
     * 根据表结构和配置信息，初始化模板
     * @return
     */
    public TemplateEntity initTemplate(){

        //读取配置文件中设置的路径
        String path = templateEntity.getPath();
        String packageName = path.substring(path.indexOf("java" + separator) + 5,path.length()).replace(separator,".");

        //从路径中解析出包名
        templateEntity.setPackageName(packageName);

        //根据数据库配置信息读取指定的数据表结构
        List<TableInfo> tableInfoList = getTableList(templateEntity.getTableName());

        //设置数据表解析信息
        for (TableInfo tableInfo : tableInfoList) {
            if(tableInfo.isKey()){
                templateEntity.setKeyField(tableInfo);
            }
        }

        //设置主键
        templateEntity.setList(tableInfoList);

        //设置基础实例名
        templateEntity.setInstanceName(getInstanceName(templateEntity.getEntityName()));
        return templateEntity;
    }

    public List<TableInfo> getTableList(String tableName){
        List<Map<String,String>> list = mapper.listTableColumn(tableName);
        List<TableInfo> tableList = new ArrayList<>();

        String prefix = "COLUMN_";
        for (Map<String,String> map : list) {

            TableInfo tableInfo = new TableInfo();

            //设置数据库字段名，用于Mapper中的查询语句
            tableInfo.setName(map.get(prefix + "NAME"));

            //字段名转换为驼峰命名格式，用于Java实体类字段
            tableInfo.setJavaName(lineToHump(tableInfo.getName()));

            //设置数据类型
            tableInfo.setType(map.get(prefix + "TYPE"));

            //字段类型转换为Java的数据格式
            tableInfo.setJavaType(TypeConverter.getJavaType(tableInfo.getType()));


            if(!StringUtils.isEmpty(map.get(prefix + "COMMENT"))){
                tableInfo.setComment(map.get(prefix + "COMMENT"));
            }
            if(!StringUtils.isEmpty(map.get(prefix + "KEY"))){
                tableInfo.setKey(true);
            }

            System.out.println(tableInfo);
            tableList.add(tableInfo);
        }
        return tableList;
    }





    public void createAll(){
        TemplateEntity template = initTemplate();
        createPO(template);
        createMapper(template);
        createService(template);
        createController(template);
    }

    public void createPO(TemplateEntity template){
        doCreate(template,separator +"po","","Entity");
    }

    public void createMapper(TemplateEntity template){
        doCreate(template,separator +"mapper","Mapper","Mapper");
    }

    public void createService(TemplateEntity template){
        doCreate(template,separator +"service","Service","Service");
    }

    public void createController(TemplateEntity template){
        doCreate(template,separator +"controller","Controller","Controller");
    }

    private void doCreate(TemplateEntity template,String pathSuffix,String classSuffix,String templateName){
        String filePath = template.getPath() + pathSuffix;
        String fileName = template.getEntityName() + classSuffix;
        template.setTemplateName(templateName + ".txt");
        createJavaFile(template,filePath,fileName);
    }

    public void createJavaFile(TemplateEntity template,String filePath, String fileName){
        try{
            //指定模板路径
            String root = System.getProperty("user.dir") + File.separator + "template" + File.separator;

            FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");

            Configuration cfg = Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
            //指定要加载的模板
            org.beetl.core.Template t = gt.getTemplate(template.getTemplateName());
            //绑定全局变量
            t.binding("template", template);
            //读取模板输出的文本
            String str = t.render();
            System.out.println(str);
            File dir = new File(filePath + File.separator );
            if(!dir.exists() && !dir.isDirectory()){
                dir.mkdirs();
            }
            File file = new File( dir + File.separator + fileName + ".java" );
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(str);
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }


    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /**
     * 下划线转驼峰
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String getInstanceName(String className){
        return className.substring(0,1).toLowerCase() + className.substring(1,className.length());
    }

    public static void main(String[] args) {

        String name = "task_start_time";
        System.out.println(lineToHump(name));

        name = "Task";
        name = name.substring(0,1).toLowerCase() + name.substring(1,name.length());
        System.out.println(name);
    }
}
