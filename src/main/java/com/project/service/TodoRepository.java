package com.project.service;

import com.project.domain.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {



    @Query(nativeQuery = true, value = "SELECT * FROM Todo WHERE done=0 AND date < CURDATE() - INTERVAL 2 DAY ORDER BY date DESC")
    List<Todo> findLateUndoneTodos();

    }
