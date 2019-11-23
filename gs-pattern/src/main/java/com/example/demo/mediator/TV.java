package com.example.demo.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class TV extends AbsColleague {
    public TV(Mediator mediator) {
        super(mediator);
        mediator.register(ConcreteMediator.ColleagueName.TV.name(), this);
    }

    public void startTV() {
        System.out.println("打开电视");
    }

    public void finishTV() {
        System.out.println("关闭电视");
    }
}
