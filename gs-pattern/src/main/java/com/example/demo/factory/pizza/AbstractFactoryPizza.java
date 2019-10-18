package com.example.demo.factory.pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/14
 */
public abstract class AbstractFactoryPizza {
    public AbstractFactoryPizza() {
        do {
            Pizza pizza = createPizza(getType());
            if (null != pizza) {
                pizza.prepare();
                pizza.baking();
                pizza.cut();
                pizza.box();
            }
        } while (true);
    }

    protected abstract Pizza createPizza(String type);

    private String getType() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入你要制作的pizza类型：Cheese,Chocolate,Pepper");
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
