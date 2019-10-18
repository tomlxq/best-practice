package com.example.demo.commander;

import lombok.Data;

import java.util.Arrays;
import java.util.Stack;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
@Data
public class Controller {
    Stack<Commander> stack = new Stack<>();
    Commander[] listOn;
    Commander[] listOff;

    public Controller() {
        listOn = new Commander[5];
        listOff = new Commander[5];

        NoCommand noCommand = new NoCommand();
        for (int idx = 0; idx < 5; idx++) {
            listOn[idx] = noCommand;
            listOff[idx] = noCommand;
        }
    }

    public void setCommander(int idx, Commander onCommand, Commander offCommand) {
        listOn[idx] = onCommand;
        listOff[idx] = offCommand;
    }

    public void onButton(int idx) {
        listOn[idx].execute();
        stack.push(listOn[idx]);
    }

    public void offButton(int idx) {
        listOff[idx].execute();
    }

    public void undo() {
        stack.pop().undo();
    }
}
