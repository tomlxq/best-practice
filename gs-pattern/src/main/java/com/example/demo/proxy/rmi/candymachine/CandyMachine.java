package com.example.demo.proxy.rmi.candymachine;

import lombok.Data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
@Data
public class CandyMachine extends UnicastRemoteObject implements CandyMachineRemote {
    State hasCoinState;
    State onReadyState;
    State soldOutState;
    State soldState;
    State winnerState;
    State state;
    private String location;
    private int count;

    public CandyMachine(String location, int count) throws RemoteException {
        this.location = location;
        this.count = count;
        hasCoinState = new HasCoinState(this);
        onReadyState = new OnReadyState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        if (count > 0) {
            state = onReadyState;
        } else {
            state = soldOutState;
        }
    }

    void insertCoin() {
        this.state.insertCoin();
    }

    void returnCoin() {
        this.state.returnCoin();
    }

    void turnCranky() {
        this.state.turnCranky();
    }

    void dispense() {
        this.state.dispense();
    }

    @Override
    public String getStateName() throws RemoteException {
        return this.state.getStateName();
    }
}
