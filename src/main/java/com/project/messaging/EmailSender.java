package com.project.messaging;

public interface EmailSender {
    void sendEmail(String to, String title, String content);
}
