package com.example.demo.strategy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class ContextTest {
    public static void main(String[] args) {
        Context context = new Context(new SubwayStrategy());
        context.goToOffice();
        context = new Context(new TaxiStrategy());
        context.goToOffice();
        context = new Context(new WalkStrategy());
        context.goToOffice();
    }
}
