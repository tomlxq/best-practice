package com.example.demo.proxy.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
public class Server {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "192.168.56.1");
        try {
            RemoteService remoteService = new RemoteServiceImpl();
            LocateRegistry.createRegistry(6060);
            Naming.rebind("//192.168.56.1:6060/RemoteHello", remoteService);
            System.out.println("注册服务启动了");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
