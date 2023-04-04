package com.example.async.A2Future;

import com.example.async.MessageResult;

/**
 * ff
 *
 * @author TomLuo
 * @date 2023年03月22日 23:01
 */
public interface AsyncService {

    MessageResult sendSms(String callPrefix, String mobile, String actionType, String content);

    MessageResult sendEmail(String email, String subject, String content);
}