package com.tmdaq.etltool.core;

import java.util.List;

/**
 * @author vttmlin
 */
public class Convert {
    private String id;
    private boolean autowired;
    private List<Field> fieldList;

    Convert(String id, boolean autowired, List<Field> fieldList) {
        this.id = id;
        this.autowired = autowired;
        this.fieldList = fieldList;
    }

    String getId() {
        return id;
    }

    Convert setId(String id) {
        this.id = id;
        return this;
    }

    boolean isAutowired() {
        return autowired;
    }

    Convert setAutowired(boolean autowired) {
        this.autowired = autowired;
        return this;
    }

    List<Field> getFieldList() {
        return fieldList;
    }

    Convert setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
        return this;
    }
}
