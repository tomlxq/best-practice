package com.example.principle.pkwrapper.decorator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class HotStar extends Decorator {
    public HotStar(IStar star) {
        super(star);
    }

    @Override
    public void act() {
        System.out.println("看你怎么吹牛");
        super.act();
    }
}
