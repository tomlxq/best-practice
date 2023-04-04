package com.example.async.A5SpringApplicationEvent事件;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 能有些时候采用ApplicationEvent实现异步的使用，当程序出现异常错误的时候，需要考虑补偿机制，
 * 那么这时候可以结合Spring Retry重试来帮助我们避免这种异常造成数据不一致问题。
 *
 * @author TomLuo
 * @date 2023年03月22日 23:15
 */
@Slf4j
@Component
public class AsyncSendEmailEventHandler implements ApplicationListener<AsyncSendEmailEvent> {

    @Autowired
    private IMessageHandler mesageHandler;

    @Async("taskExecutor")
    @Override
    public void onApplicationEvent(AsyncSendEmailEvent event) {
        if (event == null) {
            return;
        }

        String email = event.getEmail();
        String subject = event.getSubject();
        String content = event.getContent();
        String targetUserId = event.getTargetUserId();
        mesageHandler.sendsendEmailSms(email, subject, content, targetUserId);
    }
}