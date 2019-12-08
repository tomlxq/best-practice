package com.tom.protocal;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/4
 */
public class MulticastServer {
    public static void main(String[] args) throws Exception {
        //地址段 224.0.0.0~239.255.255.255
        InetAddress inetAddress = InetAddress.getByName("224.5.6.7");
        MulticastSocket multicastSocket = new MulticastSocket();
        for (int i = 0; i < 10; i++) {
            String hello = "hello, jack" + i;
            byte[] bytes = hello.getBytes(Charset.forName("UTF-8"));
            multicastSocket.send(new DatagramPacket(bytes, bytes.length, inetAddress, 8888));
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
