package com.example.async;

/**
 * IMessageHandler
 *
 * @author TomLuo
 * @date 2023年03月22日 23:03
 */
public interface IMessageHandler {
    void sendSms(String callPrefix, String mobile, String actionType, String content);

    void sendsendEmail(String email, String subject, String content);
}
