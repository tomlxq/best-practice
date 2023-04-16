package com.example.demo.template;

/**
 * 冲泡机,泡步骤
 * 1. 烧开水
 * 2. 准备杯子，放料
 * 3. 冲泡
 * 4. 放辅料
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public abstract class Beverage {
    public final void templateMethod() {
        boilWater();
        brew();
        pourInCup();
        if (wantAddCondiments()) {
            addCondiments();
        }
    }

    protected boolean wantAddCondiments() {
        return true;
    }

    protected abstract void addCondiments();

    private final void pourInCup() {
        System.out.println("冲泡并放入杯中");
    }

    protected abstract void brew();

    private final void boilWater() {
        System.out.println("烧开水");
    }
}
