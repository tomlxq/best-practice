package com.example.demo.proxy.cglib;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/19
 */
public class CGLibMatchmakerTest {
    public static void main(String[] args) {
        TomPerson person= (TomPerson)new CGLibMatchmaker().getInstance(new TomPerson());
        System.out.println(person.getClass());
        person.findLove();
    }
}
