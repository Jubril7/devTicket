package com.dev_ticket.DTO;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDTO {
    private Long todoId;
    private String ticket;
    private Boolean isTicketDone;
}
