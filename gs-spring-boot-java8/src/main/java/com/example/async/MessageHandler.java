package com.example.async;

import org.springframework.stereotype.Component;

/**
 * MessageHandler
 *
 * @author TomLuo
 * @date 2023年03月22日 23:06
 */
@Component
public class MessageHandler implements IMessageHandler{
    @Override
    public void sendSms(String callPrefix, String mobile, String actionType, String content) {

    }

    @Override
    public void sendsendEmail(String email, String subject, String content) {

    }
}