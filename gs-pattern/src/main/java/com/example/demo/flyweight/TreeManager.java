package com.example.demo.flyweight;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/4
 */
public class TreeManager {
    int count = 10000000;
    int[] aryXcoords = new int[count];
    int[] aryYcoords = new int[count];
    int[] aryAges = new int[count];
    TreeFlyWeight treeFlyWeight;

    public TreeManager() {
        treeFlyWeight = new TreeFlyWeight();
        for (int idx = 0; idx < count; idx++) {
            aryXcoords[idx] = (int) (Math.random() * count);
            aryYcoords[idx] = (int) (Math.random() * count);
            aryAges[idx] = (int) (Math.random() * count / 5);
        }
    }

    public void display() {
        for (int idx = 0; idx < count; idx++) {
            treeFlyWeight.display(aryXcoords[idx], aryYcoords[idx], aryAges[idx]);
        }
    }
}
