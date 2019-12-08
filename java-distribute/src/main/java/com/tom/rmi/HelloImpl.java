package com.tom.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/6
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {
    protected HelloImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) {
        return "hello," + name;
    }
}
