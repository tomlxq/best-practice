package com.example.async.A5SpringApplicationEvent事件;

/**
 * IMessageHandler
 *
 * @author TomLuo
 * @date 2023年03月22日 23:18
 */
public interface IMessageHandler {
   void  sendsendEmailSms(String email, String subject, String content, String targetUserId);
}
