package com.example.demo.proxy.rmi.candymachine;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public interface CandyMachineRemote extends Remote {
    String getLocation() throws RemoteException;

    int getCount() throws RemoteException;

    String getStateName() throws RemoteException;
}
