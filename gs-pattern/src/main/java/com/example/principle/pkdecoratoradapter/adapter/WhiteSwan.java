package com.example.principle.pkdecoratoradapter.adapter;

import com.example.principle.pkdecoratoradapter.decorator.Swan;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class WhiteSwan implements Swan {
    //白天鹅的叫声
    public void cry() {
        System.out.println("叫声是克噜——克噜——克噜");
    }

    //白天鹅的外形
    public void desAppearance() {
        System.out.println("外形是纯白色，惹人喜爱");
    }

    //天鹅是能够飞行的
    public void fly() {
        System.out.println("能够飞行");
    }
}