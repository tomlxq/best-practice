package com.example.demo.delegate;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class DispatcherTest {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(new ExecutorA());
        dispatcher.doing();
    }
}
