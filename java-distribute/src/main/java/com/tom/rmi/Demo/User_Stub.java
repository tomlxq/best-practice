package com.tom.rmi.Demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/7
 */
public class User_Stub {
    Socket socket;

    public User_Stub() throws IOException {
        this.socket = new Socket("localhost", 500);
    }

    public int getAge() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
        objectOutputStream.writeObject("age");
        objectOutputStream.flush();
        ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        int age = objectInputStream.readInt();
        return age;
    }
}
