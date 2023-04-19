package com.tom.rmi.Demo;

import java.io.IOException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/7
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        User_Stub user_stub = new User_Stub();
        System.out.println(user_stub.getAge());
    }
}
