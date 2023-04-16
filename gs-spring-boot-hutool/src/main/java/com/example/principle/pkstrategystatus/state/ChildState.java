package com.example.principle.pkstrategystatus.state;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class ChildState extends HumanState {
    //儿童的工作就是玩耍
    public void work() {
        System.out.println("儿童的工作是玩耍！");
        super.human.setState(Human.ADULT_STATE);
    }
}
