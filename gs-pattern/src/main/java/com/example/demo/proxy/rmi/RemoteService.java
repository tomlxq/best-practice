package com.example.demo.proxy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
public interface RemoteService extends Remote {
    String sayHello() throws RemoteException;
}
