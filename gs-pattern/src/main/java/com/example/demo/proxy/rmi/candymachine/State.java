package com.example.demo.proxy.rmi.candymachine;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
public interface State {
    void insertCoin();

    void returnCoin();

    void turnCranky();

    void dispense();

    void printState();

    String getStateName();
}
