package com.todo.domain;

import com.todo.dto.TodoDto;
import com.todo.vo.TodoComplete;
import com.todo.vo.TodoDesc;
import com.todo.vo.TodoId;

public class TodoDomainService {
    private final TodoFactory todoFactory;

    public TodoDomainService(TodoFactory todoFactory) {
        this.todoFactory = todoFactory;
    }

    public Todo createValidTodoInstance(TodoDto todoDto) {
        TodoId todoId = new TodoId(todoDto.getId());
        TodoDesc todoDesc = new TodoDesc(todoDto.getDesc());
        TodoComplete todoComplete = new TodoComplete(todoDto.isCompleted());
        int version = todoDto.getVersion();

        return todoFactory.createTodo(todoId, todoDesc, todoComplete, version);
    }
}
