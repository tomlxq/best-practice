package com.example.demo.memento.simplifyclone;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class MementoCareTakerTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("初始状态");
        originator.showState();
        originator.createMemento();
        originator.setState("改后变的状态");
        originator.showState();
        originator.restoreMemento();
        originator.showState();
    }
}
