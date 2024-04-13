package com.todo.vo;

public class TodoComplete {
    private final boolean completed;

    public TodoComplete(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }
}
