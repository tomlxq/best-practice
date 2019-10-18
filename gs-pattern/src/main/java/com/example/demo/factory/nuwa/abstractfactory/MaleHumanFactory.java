package com.example.demo.factory.nuwa.abstractfactory;

import com.example.demo.factory.nuwa.factorymethod.YellowHuman;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/16
 */
public class MaleHumanFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
}
