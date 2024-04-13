package com.todo;

import com.todo.controller.Controller;
import com.todo.domain.TodoFactoryImpl;
import com.todo.dto.TodoDto;
import com.todo.repository.TodoRepository;
import com.todo.repository.TodoRepositoryImpl;
import com.todo.repository.datamodel.TodoDataModel;
import com.todo.service.TodoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager;
        TodoRepository todoRepository;
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo-app")) {
            entityManager = factory.createEntityManager();
            todoRepository = new TodoRepositoryImpl(entityManager);

            TodoDataModel todoDataModel = new TodoDataModel(1, "hey", false, 1);

            TodoService todoService = new TodoService(new TodoFactoryImpl(), todoRepository);

            Controller controller = new Controller(todoService);

            TodoDto todoDto = new TodoDto(1, "hey", false);
            TodoDto todoDto2 = new TodoDto(2, "hello", true);

            System.out.println("first add: " + controller.addTodo(todoDto));
            System.out.println("first add: " + controller.addTodo(todoDto2));

            System.out.println("todos: " + controller.getTodos());

//            todoRepository.addTodo(todoDataModel);
//            System.out.println(todoRepository.getTodos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
