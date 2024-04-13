package com.todo.vo;

public class TodoDesc {
    private final String desc;

    public TodoDesc(String desc) {
        if (desc == null || desc.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
