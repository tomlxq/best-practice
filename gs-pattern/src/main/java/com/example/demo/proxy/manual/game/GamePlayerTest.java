package com.example.demo.proxy.manual.game;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class GamePlayerTest {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer();
        gamePlayer.login("Tom", "123");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
        System.out.println("找个代理公司帮我玩游戏。。。");
        IGamePlayer proxyGamePlayer = new ProxyGamePlayer(gamePlayer);
        proxyGamePlayer.login("Tom", "123");
        proxyGamePlayer.killBoss();
        proxyGamePlayer.upgrade();
    }
}
