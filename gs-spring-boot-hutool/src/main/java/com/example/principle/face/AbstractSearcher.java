package com.example.principle.face;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public abstract class AbstractSearcher {
    IGreatTemperamentGirl pettyGirl;

    public AbstractSearcher(IGreatTemperamentGirl pettyGirl) {
        this.pettyGirl = pettyGirl;
    }

    public abstract void show();
}
