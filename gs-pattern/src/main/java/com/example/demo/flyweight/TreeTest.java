package com.example.demo.flyweight;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/3
 */
public class TreeTest {
    int count = 10000000;
    Tree[] ary = new Tree[count];

    public TreeTest() {

        for (int idx = 0; idx < count; idx++) {
            Tree tree = new Tree((int) (Math.random() * count), (int) (Math.random() * count), (int) (Math.random() * count / 5));
            ary[idx] = tree;
        }
    }

    public void display() {
        for (int idx = 0, len = ary.length; idx < len; idx++) {
            ary[idx].display();
        }
    }
}
