package com.example.demo.proxy.manual;

import com.example.demo.proxy.jdk.Person;
import com.example.demo.proxy.jdk.TomPerson;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class TomMatchmakerTest {
    public static void main(String[] args) {
        //手动实现动态代理
        Person p3 = (Person) new TomMatchmaker().getInstance(new TomPerson());
        System.out.println(p3.getClass());
        p3.findLove();
    }
}
