package com.project.service;

import com.project.domain.Todo;
import com.project.messaging.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private EmailController emailController;


    public Todo saveTodo(Todo todo){
        return this.todoRepository.save(todo);
    }

    public List<Todo> findAllTodos(){
        return (List<Todo>) todoRepository.findAll();
    }

    public void deleteTodo(long id){
           todoRepository.delete(id);
    }

    public Todo editTodo(Todo todo){
            return this.todoRepository.save(todo);
    }

    public List<Todo> findLateUndoneTodos(){
        return todoRepository.findLateUndoneTodos();
    }

    public void sendEmailWithUndoneTodos(){
        List<Todo> todos = findLateUndoneTodos();
        if (todos.isEmpty()) return;
        emailController.send();
    }

}
