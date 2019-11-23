package com.example.demo.memento.multiback;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class MementoCareTakerTest {
    public static void main(String[] args) {
        //定义出发起人
        Originator originator = new Originator();
        //定义出备忘录管理员
        MementoCareTaker mementoCareTaker = new MementoCareTaker();
        //初始化内部状态
        originator.setState1("初始状态1");
        originator.setState2("初始状态2");
        originator.setState3("初始状态3");
        originator.showState();
        //创建一个备忘录001
        mementoCareTaker.saveBackup("001", originator.createMemento());
        originator.setState1("改后变的状态1");
        originator.setState2("改后变的状态2");
        originator.setState3("改后变的状态3");
        //创建一个备忘录002
        mementoCareTaker.saveBackup("002", originator.createMemento());
        originator.showState();
        //恢复一个备忘录001
        originator.restoreMemento(mementoCareTaker.saveBackup("001"));
        originator.showState();

        //恢复一个备忘录002
        originator.restoreMemento(mementoCareTaker.saveBackup("002"));
        originator.showState();
    }
}
