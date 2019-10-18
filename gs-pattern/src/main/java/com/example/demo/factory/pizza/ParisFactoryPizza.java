package com.example.demo.factory.pizza;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/14
 */
public class ParisFactoryPizza extends AbstractFactoryPizza {
    @Override
    protected Pizza createPizza(String type) {
        System.out.println("Paris pizza factory");
        Pizza pizza = null;
        switch (type) {
            case "Cheese":
                pizza = new CheesePizza();
                break;
            case "Chocolate":
                pizza = new ChocolatePizza();
                break;
            case "Pepper":
                pizza = new PepperPizza();
                break;
            default:
                System.out.println("不支持的pizza类型，老板还没有研发出来！");

        }
        return pizza;
    }
}
