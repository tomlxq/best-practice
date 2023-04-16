package com.example.demo.flyweight;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/3
 */
public class MainTest {
    private static void showMemory(long begin) {
        //最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        //分配内存
        long totalMemory = Runtime.getRuntime().totalMemory();
        //已分配内存的剩余内存
        long freeMemory = Runtime.getRuntime().freeMemory();
        //已用内存
        long usedMemory = totalMemory - freeMemory;
        System.out.println("最大内存：" + maxMemory / 1024 / 1024 + "兆");
        System.out.println("分配内存：" + totalMemory / 1024 / 1024 + "兆");
        System.out.println("已分配内存的剩余内存：" + freeMemory / 1024 / 1024 + "兆");
        System.out.println("已用内存：" + usedMemory / 1024 / 1024 + "兆");
        System.out.println("时间：" + (System.currentTimeMillis() - begin) / 1000 + " 秒");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~使用绳量模式~~~~~~~~~~~~~~~~~~");
        long begin = System.currentTimeMillis();
        showMemory(begin);
        begin = System.currentTimeMillis();
        PlantManager treeTest = new PlantManager();
        showMemory(begin);
        begin = System.currentTimeMillis();
        treeTest.displayPlants();
        showMemory(begin);
    }
}
