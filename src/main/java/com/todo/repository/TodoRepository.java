package com.todo.repository;

import com.todo.dto.TodoDto;
import com.todo.repository.datamodel.TodoDataModel;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    TodoDataModel save(TodoDataModel todoDataModel);
    List<TodoDataModel> findAll();
    Optional<TodoDataModel> findById(int todoId);
    TodoDataModel updateById(TodoDataModel todoDataModel);
    void deleteById(int todoId);
}
