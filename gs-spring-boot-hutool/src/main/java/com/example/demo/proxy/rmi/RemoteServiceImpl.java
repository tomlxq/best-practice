package com.example.demo.proxy.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
@SuppressWarnings("Serial")
public class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {
    protected RemoteServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "hello,world";
    }


}
