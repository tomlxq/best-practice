package com.example.demo.proxy.manual.game;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public interface IGamePlayer {
    void login(String name, String password);

    void killBoss();

    void upgrade();
}
