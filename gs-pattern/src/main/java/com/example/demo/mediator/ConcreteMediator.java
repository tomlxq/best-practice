package com.example.demo.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class ConcreteMediator implements Mediator {

    enum ColleagueName {
        Alarm, Curtain, CoffeeMachine, TV;
    }


    Map<String, AbsColleague> map = new HashMap<>();

    @Override
    public void register(String name, AbsColleague colleague) {
        map.put(name, colleague);
    }

    @Override
    public void getMessage(int stateChange, String name) {
        ColleagueName colleagueName = ColleagueName.valueOf(name);
        switch (colleagueName) {
            case Alarm:
                if (stateChange == 0) {
                    ((CoffeeMachine) map.get(ColleagueName.CoffeeMachine.name())).startCoffee();
                    ((TV) map.get(ColleagueName.TV.name())).startTV();
                }
                if (stateChange == 1) {
                    ((TV) map.get(ColleagueName.TV.name())).finishTV();
                }
                break;
            case CoffeeMachine:
                if (stateChange == 0) {
                    ((Curtain) map.get(ColleagueName.Curtain.name())).startCurtain();
                }
                if (stateChange == 1) {
                    ((Curtain) map.get(ColleagueName.Curtain.name())).finishCurtain();
                }
        }

    }

    @Override
    public void sendMessage(int stateChange) {

    }
}
