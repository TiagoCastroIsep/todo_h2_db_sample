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

    public TodoDto getTodoById(int id) {
        return todoService.findById(id);
    }

    public TodoDto updateTodo(TodoDto todoDto) {
        return todoService.updateTodo(todoDto);
    }

    public void deleteTodo(int todoId) {
        todoService.deleteTodo(todoId);
    }
}
