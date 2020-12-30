package com.keller.generator.beetl.entity;

import lombok.Data;

@Data
public class TableInfo {

    private String name;

    private String type;

    private String comment;

    private boolean isKey;

    private String javaName;

    private String javaType;
}
