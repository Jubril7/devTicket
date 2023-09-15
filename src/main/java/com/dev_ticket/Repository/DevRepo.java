package com.dev_ticket.Repository;

import com.dev_ticket.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevRepo extends JpaRepository<Todo, Long> {
    @Override
    List<Todo> findAll();
}
