package com.todo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoDtoTest {
    @Test
    void failTest() {
        TodoDto todoDto = new TodoDto(1, "todo", true, 1);

        assertEquals(2, todoDto.getId());
    }
}