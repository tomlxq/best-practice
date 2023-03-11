package com.example.lib;

/**
 * 抛异常接口
 *
 * @author TomLuo
 * @date 2023年03月11日 23:28
 */
@FunctionalInterface
public interface ThrowExceptionFunction {

    /**
     * 抛出异常信息
     *
     * @param message 异常信息
     * @return void
     **/
    void throwMessage(String message);
}