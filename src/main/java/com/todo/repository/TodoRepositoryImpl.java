package com.todo.repository;

import com.todo.domain.Todo;
import com.todo.dto.TodoDto;
import com.todo.repository.datamodel.TodoDataModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class TodoRepositoryImpl implements TodoRepository {
    private final EntityManager entityManager;

    public TodoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public TodoDataModel save(TodoDataModel todoDataModel) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(todoDataModel);
        transaction.commit();

        return todoDataModel;
    }

    @Override
    public List<TodoDataModel> findAll() {
        TypedQuery<TodoDataModel> todoTypedQuery = entityManager.createQuery("SELECT a FROM TodoDataModel a", TodoDataModel.class);
        return todoTypedQuery.getResultList();
    }

    @Override
    public Optional<TodoDataModel> findById(int todoId) {
        TodoDataModel todoDataModel = entityManager.find(TodoDataModel.class, todoId);
        return todoDataModel != null ? Optional.of(todoDataModel) : Optional.empty();
    }

    @Override
    public TodoDataModel updateById(TodoDataModel todoDataModel) {
        Optional<TodoDataModel> managedEntity = findById(todoDataModel.getId());
        if (managedEntity.isEmpty()) throw new EntityNotFoundException();
        managedEntity.get().setDesc(todoDataModel.getDesc());
        managedEntity.get().setCompleted(todoDataModel.isCompleted());
        return entityManager.merge(managedEntity.get());
    }

    @Override
    public void deleteById(int id) {
        Optional<TodoDataModel> managedEntity = findById(id);
        if (managedEntity.isEmpty()) throw new EntityNotFoundException();
        TodoDataModel managedDataModel = managedEntity.get();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(managedDataModel);
        transaction.commit();
    }
}
