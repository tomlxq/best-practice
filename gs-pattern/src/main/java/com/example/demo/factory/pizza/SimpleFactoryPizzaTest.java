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
public class SimpleFactoryPizzaTest {
    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入你要制作的pizza类型：Cheese,Chocolate,Pepper");
            String s = bufferedReader.readLine();

            Pizza pizza = new  SimpleFactoryPizza().getPizza(s);

            if (null != pizza) {
                pizza.prepare();
                pizza.baking();
                pizza.cut();
                pizza.box();
            }
        }
    }
}
