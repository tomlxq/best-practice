package com.example.demo.memento.clone;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class MementoCareTakerTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        MementoCareTaker mementoCareTaker = new MementoCareTaker();
        originator.setState("初始状态");
        originator.showState();
        mementoCareTaker.setOriginator(originator.createMemento());
        originator.setState("改后变的状态");
        originator.showState();
        originator.restoreMemento(mementoCareTaker.getOriginator());
        originator.showState();
    }
}
