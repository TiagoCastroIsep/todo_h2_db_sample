package com.todo.mapper;

import com.todo.domain.Todo;
import com.todo.repository.datamodel.TodoDataModel;

public class DomainToModelMapper {
    public TodoDataModel domainToModel(Todo todo) {
        return new TodoDataModel(
                todo.getTodoId().getId(),
                todo.getTodoDesc().getDesc(),
                todo.getTodoComplete().isCompleted()
        );
    }
}
