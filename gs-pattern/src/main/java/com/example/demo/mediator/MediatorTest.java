package com.example.demo.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class MediatorTest {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Alarm alarm = new Alarm(mediator);
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator);
        TV tv = new TV(mediator);
        Curtain curtain = new Curtain(mediator);
        alarm.sendAlarm(0);
        coffeeMachine.finishCoffee();
        alarm.sendAlarm(1);
    }
}
