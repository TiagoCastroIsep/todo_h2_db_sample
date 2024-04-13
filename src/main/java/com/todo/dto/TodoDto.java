package com.todo.dto;

public class TodoDto {
    private int id;
    private String desc;
    private boolean completed;
    private int version;

    public TodoDto(int id, String desc, boolean completed, int version) {
        this.id = id;
        this.desc = desc;
        this.completed = completed;
        this.version = version;
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

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", completed=" + completed +
                ", version=" + version +
                '}';
    }
}
