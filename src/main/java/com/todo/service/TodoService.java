package com.todo.service;

import com.todo.domain.Todo;
import com.todo.domain.TodoFactory;
import com.todo.dto.TodoDto;
import com.todo.mapper.DomainToModelMapper;
import com.todo.repository.TodoRepository;
import com.todo.repository.datamodel.TodoDataModel;
import com.todo.vo.TodoComplete;
import com.todo.vo.TodoDesc;
import com.todo.vo.TodoId;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private final TodoFactory todoFactory;
    private final TodoRepository todoRepository;

    public TodoService(TodoFactory todoFactory, TodoRepository todoRepository) {
        this.todoFactory = todoFactory;
        this.todoRepository = todoRepository;
    }

    public TodoDto addTodo(TodoDto todoDto) {
        TodoId todoId = new TodoId(todoDto.getId());
        TodoDesc todoDesc = new TodoDesc(todoDto.getDesc());
        TodoComplete todoComplete = new TodoComplete(todoDto.isCompleted());

        Todo todo = todoFactory.createTodo(todoId, todoDesc, todoComplete);
        System.out.println(todo);

        TodoDataModel todoDataModel = new DomainToModelMapper().domainToModel(todo);

        TodoDataModel result = todoRepository.addTodo(todoDataModel);

        return new TodoDto(result.getId(), result.getDesc(), result.isCompleted());
    }

    public List<TodoDto> findAll() {
        List<TodoDataModel> todoDataModels = todoRepository.getTodos();
        List<TodoDto> todoDtos = new ArrayList<>();

        for (TodoDataModel todoDataModel : todoDataModels) {
            todoDtos.add(new TodoDto(todoDataModel.getId(), todoDataModel.getDesc(), todoDataModel.isCompleted()));
        }

        return todoDtos;
    }
}
