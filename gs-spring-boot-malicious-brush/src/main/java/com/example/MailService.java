package com.example;

import org.springframework.mail.SimpleMailMessage;

/**
 * MailService
 *
 * @author TomLuo
 * @date 2023年06月06日 4:51
 */
//@Service
//@RequiredArgsConstructor
//@ConditionalOnProperty(prefix = "spring.mail", name = "host")
public class MailService {
    //private final JavaMailSenderImpl mailSender;
    public void sendNotificationEmail(String subject, String content, String... recipients) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sender@example.com");
        message.setTo(recipients);
        message.setSubject(subject);
        message.setText(content);

        //mailSender.send(message);
    }
}
