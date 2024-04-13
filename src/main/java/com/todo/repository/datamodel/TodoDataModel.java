package com.todo.repository.datamodel;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class TodoDataModel {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String desc;
    private boolean completed;
    @Version
    @Column(columnDefinition = "integer DEFAULT 0", nullable = false)
    private int version;

    public TodoDataModel() {
    }

    public TodoDataModel(String desc, boolean completed) {
        this.desc = desc;
        this.completed = completed;
    }

    public TodoDataModel(int id, String desc, boolean completed) {
        this.id = id;
        this.desc = desc;
        this.completed = completed;
    }

    public TodoDataModel(int id, String desc, boolean completed, int version) {
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
        return "TodoDataModel{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", completed=" + completed +
                ", version=" + version +
                '}';
    }
}
