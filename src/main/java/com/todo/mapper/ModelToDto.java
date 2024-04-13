package com.todo.mapper;

import com.todo.dto.TodoDto;
import com.todo.repository.datamodel.TodoDataModel;

public class ModelToDto {
    public TodoDto modelToDto(TodoDataModel todoDataModel) {
        return new TodoDto(todoDataModel.getId(), todoDataModel.getDesc(), todoDataModel.isCompleted(), todoDataModel.getVersion());
    }
}
