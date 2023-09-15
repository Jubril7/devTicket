package com.dev_ticket.Service;

import com.dev_ticket.DTO.TodoDTO;
import com.dev_ticket.Model.Todo;
import com.dev_ticket.Repository.DevRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class DevService {

    private final DevRepo devRepo;
    public List<Todo> getAllTodos(TodoDTO todoDTO) {
        return devRepo.findAll();
    }
    public Todo saveTodo(@RequestBody TodoDTO todoDTO) {
        Todo todo = new Todo(todoDTO);
        log.info("I'm here===>");
        return devRepo.save(todo);
    }

    public Todo updateTodo(Long id, TodoDTO todoDTO) {
        Todo todo = new Todo(todoDTO);
        Optional<Todo> todoOpt = devRepo.findById(id);

        if(todoOpt.isPresent()) {
            Todo item = todoOpt.get();
            item.setIsTicketDone(todo.getIsTicketDone());
            item.setTicket(todo.getTicket());
            return item;
        }
        return null;
    }
}

