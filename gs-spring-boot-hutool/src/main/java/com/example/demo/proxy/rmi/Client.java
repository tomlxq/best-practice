package com.example.demo.proxy.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
public class Client {
    public static void main(String[] args) {
        try {
            RemoteService remoteService = (RemoteService) Naming.lookup("rmi://192.168.56.1:6060/RemoteHello");
            System.out.println(remoteService.sayHello());
            ;
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
