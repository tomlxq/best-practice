package com.tom.protocal;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public class SocketServerDemo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
            while (true) {
                Socket accept = serverSocket.accept();
                new Thread(() -> {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()));
                        while (true) {
                            String s = bufferedReader.readLine();
                            if (s == null) {
                                break;
                            }
                            System.out.println("服务器接收到的数据：" + s);
                            printWriter.println("Hello rose");
                            printWriter.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(serverSocket);
        }
    }
}
