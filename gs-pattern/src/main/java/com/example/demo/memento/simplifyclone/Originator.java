package com.example.demo.memento.simplifyclone;

import lombok.Getter;
import lombok.Setter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
@Setter
@Getter
public class Originator implements Cloneable {
    private Originator backup;
    //内部状态
    private String state;

    //创建一个备忘录
    public void createMemento() {
        this.backup = this.clone();
    }

    //恢复一个备忘录
    public void restoreMemento() {
        this.setState(this.backup.getState());
    }

    public void showState() {
        System.out.println(this.getState());
    }

    public Originator clone() {
        try {
            return (Originator) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
