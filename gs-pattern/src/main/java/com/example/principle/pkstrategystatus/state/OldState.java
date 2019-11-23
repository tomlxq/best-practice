package com.example.principle.pkstrategystatus.state;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class OldState extends HumanState {
    //老年人的工作就是享受天伦之乐
    @Override
    public void work() {
        System.out.println("老年人的工作就是享受天伦之乐！");
    }
}