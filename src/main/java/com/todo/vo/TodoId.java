package com.todo.vo;

public class TodoId {
    private final int id;

    public TodoId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TodoId{" +
                "id=" + id +
                '}';
    }
}
