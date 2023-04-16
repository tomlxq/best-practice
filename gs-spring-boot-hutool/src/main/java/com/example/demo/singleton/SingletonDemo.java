package com.example.demo.singleton;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class SingletonDemo  {
    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance());
        System.out.println(Singleton2.getInstance());
        System.out.println(Singleton3.getInstance());
        System.out.println(Singleton4.getInstance());
        System.out.println(Singleton5.getInstance());
        System.out.println(Singleton6.getInstance());
        System.out.println(Singleton7.getInstance());
        Singleton8.INSTANCE.whatEverMethod();
    }
}
