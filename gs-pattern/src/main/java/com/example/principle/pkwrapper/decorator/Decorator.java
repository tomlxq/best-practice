package com.example.principle.pkwrapper.decorator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Decorator implements IStar {
    private IStar star;

    public Decorator(IStar star) {
        this.star = star;
    }

    @Override
    public void act() {
        this.star.act();
    }
}
