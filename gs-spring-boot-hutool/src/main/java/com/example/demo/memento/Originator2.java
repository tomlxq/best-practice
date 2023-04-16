package com.example.demo.memento;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class Originator2 {
    private ArrayList<String> state;

    public Originator2() {
        this.state = new ArrayList<>();
    }

    public MementoIF createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(MementoIF mementoIF) {
        this.state = ((Memento) mementoIF).getState();
    }

    public void showState() {
        System.out.println(JSON.toJSONString(this.state, true));
    }

    public void testState1() {
        this.state = new ArrayList<>();
        state.add("blood:500");
        state.add("process:gate1");
        state.add("enemy:50");
    }

    public void testState2() {
        this.state = new ArrayList<>();
        state.add("blood:200");
        state.add("process:gate3");
        state.add("enemy:510");
    }

    @Setter
    @Getter
    private class Memento implements MementoIF {
        private ArrayList<String> state;

        public Memento(ArrayList<String> state) {
            this.state = state;
        }
    }
}
