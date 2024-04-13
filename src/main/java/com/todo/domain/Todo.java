package com.todo.domain;

import com.todo.vo.TodoComplete;
import com.todo.vo.TodoDesc;
import com.todo.vo.TodoId;

public class Todo {
    private final TodoId todoId;
    private final TodoDesc todoDesc;
    private final TodoComplete todoComplete;

    public Todo(TodoId todoId, TodoDesc todoDesc, TodoComplete todoComplete) {
        this.todoId = todoId;
        this.todoDesc = todoDesc;
        this.todoComplete = todoComplete;
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

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", todoDesc=" + todoDesc +
                ", todoComplete=" + todoComplete +
                '}';
    }
}
