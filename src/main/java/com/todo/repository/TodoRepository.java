package com.todo.repository;

import com.todo.repository.datamodel.TodoDataModel;

import java.util.List;

public interface TodoRepository {
    TodoDataModel addTodo(TodoDataModel todoDataModel);
    List<TodoDataModel> getTodos();
}
