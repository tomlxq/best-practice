package com.example.demo.proxy.manual.game;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class GamePlayer implements IGamePlayer {
    private String name;

    @Override
    public void login(String name, String password) {
        this.name = name;
        System.out.println(this.name + " 登陆游戏系统成功！");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + " 打怪！");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + " 又升了一级！");
    }
}
