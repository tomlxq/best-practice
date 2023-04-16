package com.example.principle.pkmediatorfacade.facade;

import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Client {
    public static void main(String[] args) {
//定义门面
        HRFacade facade = new HRFacade();
        System.out.println("===外系统查询总收入===");
        int salary = facade.querySalary("张三", new Date(System.
                currentTimeMillis()));
        System.out.println("张三 11月 总收入为：" + salary);
//再查询出勤天数
        System.out.println("\n===外系统查询出勤天数===");
        int workDays = facade.queryWorkDays("李四");
        System.out.println("李四 本月出勤：" + workDays);
    }
}
