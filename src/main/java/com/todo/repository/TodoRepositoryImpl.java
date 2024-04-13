package com.todo.repository;

import com.todo.repository.datamodel.TodoDataModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TodoRepositoryImpl implements TodoRepository {
    private final EntityManager entityManager;

    public TodoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public TodoDataModel addTodo(TodoDataModel todoDataModel) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(todoDataModel);
        transaction.commit();

        return todoDataModel;
    }

    @Override
    public List<TodoDataModel> getTodos() {
        TypedQuery<TodoDataModel> todoTypedQuery = entityManager.createQuery("SELECT a FROM TodoDataModel a", TodoDataModel.class);
        return todoTypedQuery.getResultList();
    }
}
