package com.example.principle.pkmediatorfacade.facade;

import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Performance {
    //基本工资
    private BasicSalary salary = new BasicSalary();

    //绩效奖励
    public int getPerformanceValue() {
//随机绩效
        int perf = (new Random()).nextInt(100);
        return salary.getBasicSalary() * perf / 100;
    }
}