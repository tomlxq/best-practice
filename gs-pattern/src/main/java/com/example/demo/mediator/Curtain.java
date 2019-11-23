package com.example.demo.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class Curtain extends AbsColleague {
    public Curtain(Mediator mediator) {
        super(mediator);
        mediator.register(ConcreteMediator.ColleagueName.Curtain.name(), this);
    }

    public void startCurtain() {
        System.out.println("打开窗帘");
    }

    public void finishCurtain() {
        System.out.println("关闭窗帘");
    }
}
