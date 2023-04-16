package com.example.demo.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class CoffeeMachine extends AbsColleague {
    public CoffeeMachine(Mediator mediator) {
        super(mediator);
        mediator.register(ConcreteMediator.ColleagueName.CoffeeMachine.name(), this);
    }

    public void startCoffee() {
        System.out.println("开始煮咖啡");
    }

    public void finishCoffee() {
        System.out.println("咖啡煮好了");
        super.mediator.getMessage(1, ConcreteMediator.ColleagueName.CoffeeMachine.name());
    }
}
