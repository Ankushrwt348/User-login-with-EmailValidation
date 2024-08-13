package com.Ankush.Userlogin.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Component
public class EmailService implements EmailSender{

    private  final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

   @Autowired
    private  JavaMailSender mailSender;

    @Async
    @Override
    public void send(String to, String email) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"utf-8");
            mimeMessageHelper.setText(email,true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom("rawatankush348@gmail.com");
            mimeMessageHelper.setSubject("Confirmation Mail");
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            LOGGER.error(e.getMessage());
            throw new IllegalStateException("Failed to send email");
        }
    }
}
