package com.dev_ticket.Model;

import com.dev_ticket.DTO.TodoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long todoId;
    @Column(nullable = false)
    private String ticket;
    private Boolean isTicketDone;

    public Todo(TodoDTO todoDTO) {
        this.ticket = todoDTO.getTicket();
        this.isTicketDone = todoDTO.getIsTicketDone();
    }
}
