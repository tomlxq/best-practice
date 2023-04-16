package com.example.demo.factory.nuwa.factorymethod;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/15
 */
public class NuwaTest {
    public static void main(String[] args) {
        HumanFactory humanFactory = new HumanFactory();
        System.out.println("开天辟地，未有人民，女娲搏黄土做人");
        WhiteHuman whiteHuman = humanFactory.createHuman(WhiteHuman.class);
        whiteHuman.color();
        whiteHuman.talk();

        BlackHuman blackHuman = humanFactory.createHuman(BlackHuman.class);
        blackHuman.color();
        blackHuman.talk();

        YellowHuman yellowHuman = humanFactory.createHuman(YellowHuman.class);
        yellowHuman.color();
        yellowHuman.talk();
    }
}
