package com.example.demo.factory.nuwa.abstractfactory;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/16
 */
public class FemaleHumanFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
}
