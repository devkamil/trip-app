package com.project.messaging;

import com.project.service.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Component
public class EmailController {

    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @Autowired
    private TodoRepository todoRepository;


    public void send(){
        Context context = new Context();
        context.setVariable("header", "ToDo App mailing");
        context.setVariable("title", "Undone things to do (sorted by date):");
        context.setVariable("description", todoRepository.findLateUndoneTodos() );

        String body = templateEngine.process("template", context);
        emailSender.sendEmail("TO", "ToDo App Undone Things", body);
    }

}
