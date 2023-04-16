package com.example.demo.proxy.rmi.candymachine;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class HasCoinState implements State {
    CandyMachine candyMachine;

    public HasCoinState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("你不能插入另一个硬币了");
    }

    @Override
    public void returnCoin() {
        //this.candyMachine.setState(new ReturnC);
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
