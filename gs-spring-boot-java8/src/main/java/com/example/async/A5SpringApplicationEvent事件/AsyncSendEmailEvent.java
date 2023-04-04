package com.example.async.A5SpringApplicationEvent事件;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 4.5.1 定义事件
 *
 * @author TomLuo
 * @date 2023年03月22日 23:12
 */
@Data
public class AsyncSendEmailEvent extends ApplicationEvent {
    /**
     * 邮箱
     **/
    private String email;

    /**
     * 主题
     **/
    private String subject;

    /**
     * 内容
     **/
    private String content;

    /**
     * 接收者
     **/
    private String targetUserId;

    public AsyncSendEmailEvent(Object source) {
        super(source);
    }
}