package com.example.demo.template;

/**
 * 冲泡机
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public abstract class Bevegrage {
    /**
     * 冲泡步骤
     * 1. 烧开水
     * 2. 准备杯子，放料
     * 3. 冲泡
     * 4. 放辅料
     * final 不能被重写
     */
    public final void create() {
        boilWater();
        putMeterial();
        brewMethods();
        putIngredients();
    }

    protected abstract void putIngredients();

    private void brewMethods() {
        System.out.println("冲泡");
    }

    protected abstract void putMeterial();

    private void boilWater() {
        System.out.println("烧开水");
    }
}
