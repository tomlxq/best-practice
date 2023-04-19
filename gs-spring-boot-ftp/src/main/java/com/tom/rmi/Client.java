package com.tom.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/6
 */
public class Client {
    public static void main(String[] args) {
        try {
            IHello hello = (IHello) Naming.lookup(Server.getRmiURL());
            System.out.println(hello.sayHello("jack"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
