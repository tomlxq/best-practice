package com.example.demo.proxy.manual.dynamicgame;


import com.example.demo.proxy.manual.game.GamePlayer;
import com.example.demo.proxy.manual.game.IGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class GamePlayHandlerTest {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer();
        InvocationHandler handler = new GamePlayHandler(gamePlayer);
        ClassLoader classLoader = gamePlayer.getClass().getClassLoader();
        Class<?>[] interfaces = gamePlayer.getClass().getInterfaces();
        IGamePlayer proxyGamePlayer = (IGamePlayer) Proxy.newProxyInstance(classLoader, interfaces, handler);
        proxyGamePlayer.login("Tom", "123");
        proxyGamePlayer.killBoss();
        proxyGamePlayer.upgrade();
    }
}
