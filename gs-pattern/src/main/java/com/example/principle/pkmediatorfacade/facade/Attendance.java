package com.example.principle.pkmediatorfacade.facade;

import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Attendance {
    //得到出勤天数
    public int getWorkDays() {
        return (new Random()).nextInt(30);
    }
}