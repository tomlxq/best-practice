package com.example.principle.pkmediatorfacade.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Client {
    public static void main(String[] args) {
//定义中介者
        Mediator mediator = new Mediator();
//定义各个同事类
        IPosition position = new Position(mediator);
        ISalary salary = new Salary(mediator);
        ITax tax = new Tax(mediator);
//职位提升了
        System.out.println("===职位提升===");
        position.promote();
    }
}
