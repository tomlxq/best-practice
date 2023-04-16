package com.example.demo.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public interface Mediator {


    void register(String name, AbsColleague colleague);

    void getMessage(int stateChange, String name);

    void sendMessage(int stateChange);

}
