package com.tom.rmi.Demo;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/7
 */
public class TestServer {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(28);
        UserSkeleton userSkeleton = new UserSkeleton(user);
        userSkeleton.start();

    }
}
