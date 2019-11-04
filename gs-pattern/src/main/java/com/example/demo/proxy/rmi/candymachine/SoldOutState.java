package com.example.demo.proxy.rmi.candymachine;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class SoldOutState implements State {
    CandyMachine candyMachine;

    public SoldOutState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void insertCoin() {

    }

    @Override
    public void returnCoin() {

    }

    @Override
    public void turnCranky() {

    }

    @Override
    public void dispense() {

    }

    @Override
    public void printState() {

    }

    @Override
    public String getStateName() {
        return null;
    }
}
