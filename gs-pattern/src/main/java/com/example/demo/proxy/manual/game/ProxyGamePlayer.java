package com.example.demo.proxy.manual.game;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class ProxyGamePlayer implements IGamePlayer {
    IGamePlayer gamePlayer;

    public ProxyGamePlayer(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String name, String password) {
        this.gamePlayer.login(name, password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
