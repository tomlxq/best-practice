package com.example.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * qq
 *
 * @author TomLuo
 * @date 2023年03月23日 23:29
 */

public class MyTestEvent extends ApplicationEvent {
    @Getter
    @Setter
    private String msg;

    public MyTestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
