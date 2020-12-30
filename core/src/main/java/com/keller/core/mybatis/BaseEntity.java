package com.keller.core.mybatis;

import lombok.Data;

/**
 * @author yangkaile
 * @date 2019-07-17 16:59:52
 * BaseEntity，使用复杂查询（带条件的增删改查和分页查询）时需要继承的父类
 * 该类提供了可供选择的多条件查询方式、排序方式、分页查询相关参数等
 * 数据实体类继承该类即可使用
 *
 */
@Data
public class BaseEntity {
    /**
     * 页面大小
     */
    private int baseSize = 10;
    /**
     * 要查询的页码
     */
    private int basePage = 1;
    /**
     * 根据页面大小和要查询的页码计算出的起始行号
     */
    private int baseStartRows = 0;

    /**
     * 自定义查询条件,指定自定义查询条件后，执行查询语句时，只会选择自定义的查询条件执行，忽略其他条件
     */
    private String baseCondition = null;

    public void setBaseSize(int baseSize) {
        this.baseSize = baseSize;
        this.baseStartRows = this.baseSize * (this.basePage - 1);
    }

    public void setBasePage(int basePage) {
        this.baseStartRows = this.baseSize * (this.basePage - 1);
        this.basePage = basePage;
    }
}
