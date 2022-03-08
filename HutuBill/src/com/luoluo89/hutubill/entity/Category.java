package com.luoluo89.hutubill.entity;

/**
 *消费分类实体
 */
public class Category {

    private int id;
    private String name;
    private int recordNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
}
