package com.todo;

import com.todo.controller.Controller;
import com.todo.domain.TodoDomainService;
import com.todo.domain.TodoFactoryImpl;
import com.todo.dto.TodoDto;
import com.todo.repository.TodoRepository;
import com.todo.repository.TodoRepositoryImpl;
import com.todo.service.TodoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class Ui {
    private static int currentId = 1;

    public static void main(String[] args) {
        EntityManager entityManager;
        TodoRepository todoRepository;
        try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo-app")) {
            System.out.println("\n\nWelcome to you todo list: \n");
            entityManager = factory.createEntityManager();

            todoRepository = new TodoRepositoryImpl(entityManager);
            TodoService todoService = new TodoService(new TodoDomainService(new TodoFactoryImpl()), todoRepository);
            Controller controller = new Controller(todoService);

            renderTodos(controller);

            while (true) {
                int selectedOption = renderMenuAndSelectOption();

                if (selectedOption == 1) {
                    addTodoLogic(currentId, controller);
                    renderTodos(controller);
                    currentId++;
                }
                if (selectedOption == 2) {
                    updateDescription(controller);
                    renderTodos(controller);
                }
                if (selectedOption == 3) {
                    updateCompletedState(controller);
                    renderTodos(controller);
                }
                if (selectedOption == 4) {
                    deleteTodo(controller);
                    renderTodos(controller);
                }
                if (selectedOption == 5) {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void renderTodos(Controller controller) {
        List<TodoDto> todoDtoList = controller.getTodos();
        currentId = updateCurrentId(todoDtoList);

        if (todoDtoList.isEmpty()) {
            System.out.println("Your todo list is empty");
        } else {
            for (TodoDto todoDto : todoDtoList) {
                System.out.println("#" + todoDto.getId() + ". " + todoDto.getDesc() + " --> " +
                        (todoDto.isCompleted() ? "complete" : "incomplete"));
            }
        }
    }

    public static int renderMenuAndSelectOption() {
        System.out.println("\nSelect one option: ");
        System.out.println("1. Add new todo\n2. Update todo description\n3. Update todo completion state\n4. Delete todo\n5. Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void addTodoLogic(int currentId, Controller controller) {
        System.out.println("Add description:");
        Scanner scannerAdd = new Scanner(System.in);
        String description = scannerAdd.nextLine();
        TodoDto todoDto = new TodoDto(currentId + 1, description, false, 0);

        controller.addTodo(todoDto);

        System.out.println("Added! \n");
    }

    public static int updateCurrentId(List<TodoDto> todoDtoList) {
        int currentId = 0;

        if (!todoDtoList.isEmpty()) {
            currentId = todoDtoList.getLast().getId();
        }

        return currentId;
    }

    public static void updateDescription(Controller controller) {
        TodoDto foundDto = findById(controller);

        System.out.println("Select new todo Description:");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();

        TodoDto todoDto = new TodoDto(foundDto.getId(), description, foundDto.isCompleted(), foundDto.getVersion());

        controller.updateTodo(todoDto);
    }

    public static void updateCompletedState(Controller controller) {
        TodoDto foundDto = findById(controller);

        System.out.println("Select new todo Completion (true/false):");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();

        boolean isCompleted = foundDto.isCompleted();

        if (selection.equals("true") && isCompleted) {
            System.out.println("This is already completed.");
        } else if (selection.equals("false") && isCompleted) {
            TodoDto todoDto = new TodoDto(foundDto.getId(), foundDto.getDesc(), false, foundDto.getVersion());

            controller.updateTodo(todoDto);
        } else if (selection.equals("true") && !foundDto.isCompleted()) {
            TodoDto todoDto = new TodoDto(foundDto.getId(), foundDto.getDesc(), true, foundDto.getVersion());

            controller.updateTodo(todoDto);
        } else if (selection.equals("false") && !foundDto.isCompleted()) {
            System.out.println("This is already not completed.");
        } else {
            System.out.println("Invalid input, no update action");
        }
    }

    public static void deleteTodo(Controller controller) {
        // TODO: not needed call to findById
        TodoDto todoDto = findById(controller);

        controller.deleteTodo(todoDto.getId());
    }

    public static TodoDto findById(Controller controller) {
        TodoDto foundDto;
        do {
            System.out.println("Select todo # to update:");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            foundDto = controller.getTodoById(id);
        } while (foundDto == null);

        return foundDto;
    }
}
