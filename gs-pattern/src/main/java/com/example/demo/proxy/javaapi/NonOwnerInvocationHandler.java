package com.example.demo.proxy.javaapi;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
@AllArgsConstructor
public class NonOwnerInvocationHandler implements InvocationHandler {
    PersonBean myPerson;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (ArrayUtils.contains(new String[]{"getName", "getSex", "getBirthday", "getInterests"}, method.getName())) {
            return method.invoke(myPerson, args);
        } else {
            throw new IllegalAccessException();
            // System.out.println(method.getName()+" not support");
            // return null;
        }
    }
}
