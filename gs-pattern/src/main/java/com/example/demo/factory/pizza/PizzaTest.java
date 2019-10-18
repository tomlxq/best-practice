package com.example.demo.factory.pizza;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/14
 */
public class PizzaTest {
    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入你要制作的pizza类型：Cheese,Chocolate,Pepper");
            String s = bufferedReader.readLine();
            Pizza pizza = null;
            switch (s) {
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
            if (null != pizza) {
                pizza.prepare();
                pizza.baking();
                pizza.cut();
                pizza.box();
            }
        }
    }
}
