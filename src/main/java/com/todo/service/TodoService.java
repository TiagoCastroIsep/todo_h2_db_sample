package com.todo.service;

import com.todo.domain.Todo;
import com.todo.domain.TodoDomainService;
import com.todo.dto.TodoDto;
import com.todo.mapper.DomainToModelMapper;
import com.todo.mapper.ModelToDto;
import com.todo.repository.TodoRepository;
import com.todo.repository.datamodel.TodoDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoService {
    private final TodoDomainService todoDomainService;
    private final TodoRepository todoRepository;

    public TodoService(TodoDomainService todoDomainService, TodoRepository todoRepository) {
        this.todoDomainService = todoDomainService;
        this.todoRepository = todoRepository;
    }

    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo = todoDomainService.createValidTodoInstance(todoDto);

        TodoDataModel todoDataModel = new DomainToModelMapper().domainToModel(todo);

        TodoDataModel result = todoRepository.save(todoDataModel);

        return new TodoDto(result.getId(), result.getDesc(), result.isCompleted(), result.getVersion());
    }

    public List<TodoDto> findAll() {
        List<TodoDataModel> todoDataModels = todoRepository.findAll();
        List<TodoDto> todoDtos = new ArrayList<>();

        for (TodoDataModel todoDataModel : todoDataModels) {
            todoDtos.add(new TodoDto(todoDataModel.getId(), todoDataModel.getDesc(), todoDataModel.isCompleted(), todoDataModel.getVersion()));
        }

        return todoDtos;
    }

    public TodoDto updateTodo(TodoDto todoDto) {
        Todo todo = todoDomainService.createValidTodoInstance(todoDto);

        TodoDataModel todoDataModel = new DomainToModelMapper().domainToModel(todo);

        TodoDataModel result = todoRepository.updateById(todoDataModel);

        return new TodoDto(result.getId(), result.getDesc(), result.isCompleted(), result.getVersion());
    }

    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }

    public TodoDto findById(int id) {
        Optional<TodoDataModel> todoDataModel = todoRepository.findById(id);
        if (todoDataModel.isEmpty()) return null;
        TodoDataModel todoDmFound = todoDataModel.get();
        return new ModelToDto().modelToDto(todoDmFound);
    }
}
