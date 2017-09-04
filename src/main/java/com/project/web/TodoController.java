package com.project.web;

import com.project.domain.Todo;
import com.project.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {


    @Autowired
    private TodoService todoService;

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    @GetMapping
    public List<Todo> getTodos() {
        return (List<Todo>) todoService.findAllTodos();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable ("id") long id) {
        todoService.deleteTodo(id);
    }


    @PutMapping ("/{id}")
    public Todo edit (@RequestBody Todo todo, @PathVariable ("id") long id) {
       return this.todoService.editTodo(todo);
    }

}
