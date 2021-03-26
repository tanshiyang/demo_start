package com.example.enums;

public enum TypeEnum {
    ADMIN("管理员"),
    USER("普通用户");
    private String desc;

    TypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}