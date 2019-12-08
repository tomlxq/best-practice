package com.tom.rmi.Demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/7
 */
public class UserSkeleton extends Thread {
    User user;

    public UserSkeleton(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(500);
            Socket accept = serverSocket.accept();
            while (accept != null) {
                ObjectInputStream objectInputStream = new ObjectInputStream((accept.getInputStream()));
                String method = (String) objectInputStream.readObject();
                if (method.equalsIgnoreCase("age")) {
                    int age = this.user.getAge();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
                    objectOutputStream.writeInt(age);
                    objectOutputStream.flush();
                }
                objectInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
