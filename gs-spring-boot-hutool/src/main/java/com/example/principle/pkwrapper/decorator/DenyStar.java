package com.example.principle.pkwrapper.decorator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class DenyStar extends Decorator {
    public DenyStar(IStar star) {
        super(star);
    }

    @Override
    public void act() {
        super.act();
        System.out.println("事后还不承认");
    }
}
