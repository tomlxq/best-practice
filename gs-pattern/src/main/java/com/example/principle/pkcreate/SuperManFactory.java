package com.example.principle.pkcreate;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/13
 */
public class SuperManFactory {
    //定义一个生产超人的工厂
    public static ISuperMan createSuperMan(String type) {
//根据输入参数产生不同的超人
        if (type.equalsIgnoreCase("adult")) {
//生产成人超人
            return new AdultSuperMan();
        } else if (type.equalsIgnoreCase("child")) {
//生产未成年超人
            return new ChildSuperMan();
        } else {
            return null;
        }
    }
}