package com.example.async.A5SpringApplicationEvent事件;

import org.springframework.stereotype.Service;

/**
 * MessageHandler
 *
 * @author TomLuo
 * @date 2023年03月22日 23:18
 */
@Service
public class MessageHandler implements IMessageHandler{
    @Override
    public void sendsendEmailSms(String email, String subject, String content, String targetUserId) {

    }
}