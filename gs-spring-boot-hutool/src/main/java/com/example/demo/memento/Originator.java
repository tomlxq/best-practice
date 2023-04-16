package com.example.demo.memento;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class Originator {
    private HashMap<String, String> state;

    public Originator() {
        this.state = new HashMap<>();
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
        state.put("blood", "500");
        state.put("process", "gate1");
        state.put("enemy", "50");
    }

    public void testState2() {
        state.put("blood", "200");
        state.put("process", "gate3");
        state.put("enemy", "510");
    }

    @Setter
    @Getter
    private class Memento implements MementoIF {
        private HashMap<String, String> state;

        public Memento(HashMap<String, String> state) {
            this.state = new HashMap<>(state);
        }
    }
}
