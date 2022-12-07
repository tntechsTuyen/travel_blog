package com.travel.server.service.impl;

import com.travel.server.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendMail(String to, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tuyen.cntt.k13a@gmail.com");
        message.setTo(to);
        message.setSubject("[NO REPLY] Authorization Verify");
        message.setText(content);
        emailSender.send(message);
    }
}
