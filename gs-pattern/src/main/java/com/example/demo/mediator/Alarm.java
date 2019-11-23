package com.example.demo.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class Alarm extends AbsColleague {
    public Alarm(Mediator mediator) {
        super(mediator);
        mediator.register(ConcreteMediator.ColleagueName.Alarm.name(), this);
    }

    public void sendAlarm(int changeState) {
        super.mediator.getMessage(changeState, ConcreteMediator.ColleagueName.Alarm.name());
    }
}
