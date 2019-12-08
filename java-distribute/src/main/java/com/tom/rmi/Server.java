package com.tom.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/6
 */
public class Server {
    public static final int PORT = 9000;

    public static void main(String[] args) {
        try {
            IHello hello = new HelloImpl();
            LocateRegistry.createRegistry(PORT);
            Naming.bind(getRmiURL(), hello);
            System.out.println("服务端发布");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static String getRmiURL() {
        return String.format("rmi://localhost:%s/hello", PORT);
    }
}
