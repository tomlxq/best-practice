package com.example.demo.memento;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public class MementoCaretaker {
    HashMap<String, MementoIF> map;

    public MementoCaretaker() {
        map = new HashMap();
    }

    public void saveMemento(String name, MementoIF memento) {
        map.put(name, memento);
    }

    public MementoIF retrieveMemento(String name) {
        return map.get(name);
    }
}
