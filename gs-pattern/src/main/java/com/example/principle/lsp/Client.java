package com.example.principle.lsp;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Client {
    public static void main(String[] args) {
//产生三毛这个士兵
        Soldier sanMao = new Soldier();
//给三毛一支枪
        sanMao.setGun(new Rifle());
        sanMao.killEnemy();
    }
}
