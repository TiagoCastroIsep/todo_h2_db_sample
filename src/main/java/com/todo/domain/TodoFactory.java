package com.todo.domain;

import com.todo.vo.TodoComplete;
import com.todo.vo.TodoDesc;
import com.todo.vo.TodoId;

public interface TodoFactory {
    Todo createTodo(TodoId todoId, TodoDesc todoDesc, TodoComplete todoComplete);
}
