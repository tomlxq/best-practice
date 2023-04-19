package com.tom.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/6
 */
public interface IHello extends Remote {
    String sayHello(String name) throws RemoteException;
}
