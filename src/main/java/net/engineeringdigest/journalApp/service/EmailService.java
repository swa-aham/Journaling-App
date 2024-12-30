package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendMail(EmailDetails emailDetails) {
        try {
            String to = emailDetails.getRecipient();
            String subject = emailDetails.getSubject();
            String body = emailDetails.getMsgBody();
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            javaMailSender.send(mail);
            return "Email sent successfully";
        } catch (Exception e) {
            log.error("Error occurred while sending email. Exception ", e);
            return "Something went wrong! Email not sent.";
        }
    }
}
