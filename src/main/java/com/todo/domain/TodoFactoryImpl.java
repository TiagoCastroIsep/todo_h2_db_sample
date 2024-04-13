package com.todo.domain;

import com.todo.vo.TodoComplete;
import com.todo.vo.TodoDesc;
import com.todo.vo.TodoId;

public class TodoFactoryImpl implements TodoFactory {

    @Override
    public Todo createTodo(TodoId todoId, TodoDesc todoDesc, TodoComplete todoComplete, int version) {
        return new Todo(todoId, todoDesc, todoComplete, version);
    }
}
