package com.example.demo.flyweight;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/4
 */
public class PlantManager {
    int count = 10000000;
    int[] aryXcoords = new int[count];
    int[] aryYcoords = new int[count];
    int[] aryAges = new int[count];
    int[] aryTypes = new int[count];
    PlantFactory plantFactory;

    public PlantManager() {
        plantFactory = new PlantFactory();
        for (int idx = 0; idx < count; idx++) {
            aryXcoords[idx] = (int) (Math.random() * count);
            aryYcoords[idx] = (int) (Math.random() * count);
            aryAges[idx] = (int) (Math.random() * count) % 5;
            aryTypes[idx] = (int) (Math.random() * count) % 2;
        }
    }

    public void displayPlants() {
        for (int idx = 0; idx < count; idx++) {
            plantFactory.getPlant(aryTypes[idx]).display(aryXcoords[idx], aryYcoords[idx], aryAges[idx]);
        }
    }
}
