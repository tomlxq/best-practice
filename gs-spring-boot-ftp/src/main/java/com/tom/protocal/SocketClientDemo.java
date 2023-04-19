package com.tom.protocal;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/28
 */
public class SocketClientDemo {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            socket = new Socket("localhost", 8000);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Hello,tom!");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String s = bufferedReader.readLine();
                if (s == null) {
                    break;
                }
                System.out.println("客户端接收到消息是：" + s);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(printWriter);
            IOUtils.closeQuietly(socket);
        }
    }
}
