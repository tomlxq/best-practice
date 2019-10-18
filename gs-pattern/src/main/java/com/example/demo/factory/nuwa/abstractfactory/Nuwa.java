package com.example.demo.factory.nuwa.abstractfactory;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/16
 */
public class Nuwa {
    public static void main(String[] args) {
//第一条生产线，男性生产线
        HumanFactory maleHumanFactory = new MaleHumanFactory();
//第二条生产线，女性生产线
        HumanFactory femaleHumanFactory = new FemaleHumanFactory();
//生产线建立完毕，开始生产人了:
        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
        System.out.println("---生产一个黄色女性---");
        femaleYellowHuman.color();
        femaleYellowHuman.talk();
        femaleYellowHuman.getSex();
        System.out.println("\n---生产一个黄色男性---");
        maleYellowHuman.color();
        maleYellowHuman.talk();
        maleYellowHuman.getSex();
        /*
         * ......
         * 后面继续创建
         */
    }
}
