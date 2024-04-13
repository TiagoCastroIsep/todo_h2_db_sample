package com.todo.dto;

public class TodoDto {
    private int id;
    private String desc;
    private boolean completed;

    public TodoDto(int id, String desc, boolean completed) {
        this.id = id;
        this.desc = desc;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", completed=" + completed +
                '}';
    }
}
