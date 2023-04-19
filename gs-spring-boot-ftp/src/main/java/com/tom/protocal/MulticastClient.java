package com.tom.protocal;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/4
 */
public class MulticastClient {
    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getByName("224.5.6.7");
        MulticastSocket multicastSocket = new MulticastSocket(8888);
        multicastSocket.joinGroup(inetAddress);
        byte[] bytes = new byte[256];
        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            multicastSocket.receive(datagramPacket);
            String s = new String(datagramPacket.getData());
            System.out.println("接收到的数据：" + s);
        }
    }
}
