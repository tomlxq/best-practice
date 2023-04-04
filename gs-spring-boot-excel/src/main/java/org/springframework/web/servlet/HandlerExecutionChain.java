package org.springframework.web.servlet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/27
 */
@Data
@AllArgsConstructor
public class HandlerExecutionChain {
    private Object bean;
    private Method method;


    public HandlerExecutionChain getHandler() {
        return this;
    }
}
