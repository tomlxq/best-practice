package com.example.async.A2Future;

import com.example.async.IMessageHandler;
import com.example.async.MessageResult;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 4.4 Spring的@Async异步
 *
 * @author TomLuo
 * @date 2023年03月22日 23:01
 */
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Autowired
    private IMessageHandler mesageHandler;

    @Override
    @Async("taskExecutor")
    public MessageResult sendSms(String callPrefix, String mobile, String actionType, String content) {
        try {

            Thread.sleep(1000);
            mesageHandler.sendSms(callPrefix, mobile, actionType, content);

        } catch (Exception e) {
            log.error("发送短信异常 -> ", e);
        }
        return null;
    }

    @Override
    @Async("taskExecutor")
    public MessageResult sendEmail(String email, String subject, String content) {
        try {

            Thread.sleep(1000);
            mesageHandler.sendsendEmail(email, subject, content);

        } catch (Exception e) {
            log.error("发送email异常 -> ", e);
        }
        return null;
    }
}