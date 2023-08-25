package com.dev_ticket.Controller;

import com.dev_ticket.DTO.TodoDTO;
import com.dev_ticket.Model.Todo;
import com.dev_ticket.Service.DevService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//http://localhost:2506
@RequiredArgsConstructor
@RestController("/api/")
public class DevController {

    private final DevService devService;

    @PostMapping("save-todo")
    public ResponseEntity<Todo> addTodo(@RequestBody TodoDTO todoDTO) {
        Todo task = devService.saveTodo(todoDTO);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("all-todo-items")
    public ResponseEntity<List<Todo>> getAllTodoItems(TodoDTO todoDTO) {
        List<Todo> todos = devService.getAllTodos(todoDTO);
        return ResponseEntity.ok(todos);
    }
}
