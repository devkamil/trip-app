package com.project.messaging;

import com.project.service.TripRepository;
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
    private TripRepository tripRepository;


    public void send(){
        Context context = new Context();
        context.setVariable("header", "Trip App mailing");
        context.setVariable("title", "Difficult trips to do (sorted by date):");
        context.setVariable("description", tripRepository.findLateUndoneTrips() );

        String body = templateEngine.process("template", context);
        emailSender.sendEmail("TO", "Trip App Difficult Trips", body);
    }

}
