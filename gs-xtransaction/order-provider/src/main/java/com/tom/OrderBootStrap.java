package com.tom;

import com.alibaba.dubbo.container.Main;

/**
 * Hello world!
 *
 */
public class OrderBootStrap
{
    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        Main.main(args);
    }
}
