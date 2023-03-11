package com.example.lib;


import java.util.function.Consumer;

/**
 * 空值与非空值分支处理
 *
 * @author TomLuo
 * @date 2023年03月11日 23:49
 */
public interface PresentOrElseHandler<T extends Object> {

    /**
     * 值不为空时执行消费操作
     * 值为空时执行其他的操作
     *
     * @param action      值不为空时，执行的消费操作
     * @param emptyAction 值为空时，执行的操作
     * @return void
     **/
    void presentOrElseHandle(Consumer<? super T> action, Runnable emptyAction);

}