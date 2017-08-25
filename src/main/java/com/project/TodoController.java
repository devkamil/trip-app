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
        List<Todo> todos = (List<Todo>) todoRepository.findAll();
        return todos;
    }

//    @PostMapping
//    public void createTodo(String todo) {
//        //Zapisac do bazy
//    }



//    @GetMapping
//    public List<String> getTodos() {
//        //Podbranie listy z bazy danych
//        List<String> todos = new ArrayList<>();
//        todos.add("Coś tam");
//        return todos;
//    }


    //Stworzenie nowego zadania
    //Pobranie listy zadań
    //Modyfikacja tekstu zadania
    //Usunięcie zadnia
    //Oznaczenie zadania jako zrobionego / niezrobionego



}
