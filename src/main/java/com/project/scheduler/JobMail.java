package com.project.scheduler;


import com.project.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobMail{


    @Autowired
    private TodoService todoService;


    @Scheduled(cron = "0 18 12 * * ?")
    public void executeTask(){
        todoService.sendEmailWithUndoneTodos();
    }

}
