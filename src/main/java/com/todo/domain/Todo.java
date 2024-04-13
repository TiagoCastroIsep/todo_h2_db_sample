package com.todo.domain;

import com.todo.vo.TodoComplete;
import com.todo.vo.TodoDesc;
import com.todo.vo.TodoId;

public class Todo {
    private final TodoId todoId;
    private final TodoDesc todoDesc;
    private final TodoComplete todoComplete;
    private int version;

    public Todo(TodoId todoId, TodoDesc todoDesc, TodoComplete todoComplete, int version) {
        this.todoId = todoId;
        this.todoDesc = todoDesc;
        this.todoComplete = todoComplete;
        this.version = version;
    }

    public TodoId getTodoId() {
        return todoId;
    }

    public TodoDesc getTodoDesc() {
        return todoDesc;
    }

    public TodoComplete getTodoComplete() {
        return todoComplete;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", todoDesc=" + todoDesc +
                ", todoComplete=" + todoComplete +
                ", version=" + version +
                '}';
    }
}
