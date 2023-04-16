package com.example.demo.proxy.manual.dynamicgame;

import com.example.demo.proxy.manual.game.GamePlayer;
import com.example.demo.proxy.manual.game.IGamePlayer;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer();

        IGamePlayer proxyGamePlayer = DynamicProxy.newProxyInstance(gamePlayer);
        proxyGamePlayer.login("Tom", "123");
        proxyGamePlayer.killBoss();
        proxyGamePlayer.upgrade();
    }
}
