package com.example.principle.lsp.para;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Client {
    public static void invoker() {
//父类存在的地方，子类就应该能够存在
        Father f = new Father();
        HashMap map = new HashMap();
        f.doSomething(map);
    }

    public static void invoker2() {
//父类存在的地方，子类就应该能够存在
        Son f = new Son();
        HashMap map = new HashMap();
        f.doSomething(map);
    }

    public static void main(String[] args) {
        invoker();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        invoker2();
    }
}