package com.dev_ticket.Controller;

import com.dev_ticket.DTO.TodoDTO;
import com.dev_ticket.Model.Todo;
import com.dev_ticket.Service.DevService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class DevController {

    private final DevService devService;

    @PostMapping("save-todo")
    public ResponseEntity<?> addTodo(@RequestBody TodoDTO todoDTO) {
        Todo task = devService.saveTodo(todoDTO);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("all-todo-items")
    public ResponseEntity<?> getAllTodoItems(TodoDTO todoDTO) {
        List<Todo> todos = devService.getAllTodos(todoDTO);
        return ResponseEntity.ok(todos);
    }

    @PutMapping("update-todo")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
        Todo updatedTodo = devService.updateTodo(id, todoDTO);
        return ResponseEntity.ok(updatedTodo);
    }
}
