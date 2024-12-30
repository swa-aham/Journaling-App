package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.EmailDetails;
import net.engineeringdigest.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailServiceController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendMailController(@RequestBody EmailDetails emailDetails) {

        return emailService.sendMail(emailDetails);
    }
}
