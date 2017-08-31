package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return this.todoRepository.save(todo);
    }

    @GetMapping
    public List<Todo> getTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable ("id") long id) {
        todoRepository.delete(id);
    }


    @PutMapping ("/{id}")
    public Todo edit (@RequestBody Todo todo, @PathVariable ("id") long id) {
       return this.todoRepository.save(todo);
    }

}
