package com.example.demo.flyweight;

import lombok.Getter;
import lombok.Setter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/3
 */
@Setter
@Getter
//@AllArgsConstructor
public class Tree {
    private int xCoord;
    private int yCoord;
    private int age;

    public Tree(int xCoord, int yCoord, int age) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.age = age;
    }

    public void display() {
        // System.out.println("树的横坐标为：" + this.xCoord + " 纵坐标为：" + this.yCoord + " 树龄为：" + this.age);
    }
}
