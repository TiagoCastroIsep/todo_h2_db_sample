package com.todo.controller;

import com.todo.domain.Todo;
import com.todo.dto.TodoDto;
import com.todo.service.TodoService;

import java.util.List;

public class Controller {
    private final TodoService todoService;

    public Controller(TodoService todoService) {
        this.todoService = todoService;
    }

    public TodoDto addTodo(TodoDto todoDto) {
        return todoService.addTodo(todoDto);
    }

    public List<TodoDto> getTodos() {
        return todoService.findAll();
    }
}
