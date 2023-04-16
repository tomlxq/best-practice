package com.example.demo.memento;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class MementoCaretakerTest {
    public static void main(String[] args) {
        MementoCaretaker mememtoCaretaker = new MementoCaretaker();
        Originator originator = new Originator();
        Originator2 originator2 = new Originator2();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~游戏玩家1~~~~~~~~~~~~~~~~~~~~~~~~");
        originator.testState1();
        mememtoCaretaker.saveMemento("originator", originator.createMemento());
        originator.showState();
        originator.testState2();
        originator.showState();
        System.out.println("游戏失败，恢复到之前的状态");
        originator.restoreMemento(mememtoCaretaker.retrieveMemento("originator"));
        originator.showState();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~游戏玩家2~~~~~~~~~~~~~~~~~~~~~~~~");
        originator2.testState1();
        mememtoCaretaker.saveMemento("originator2", originator2.createMemento());
        originator2.showState();
        originator2.testState2();
        originator2.showState();
        System.out.println("游戏失败，恢复到之前的状态");
        originator2.restoreMemento(mememtoCaretaker.retrieveMemento("originator2"));
        originator2.showState();
    }
}
