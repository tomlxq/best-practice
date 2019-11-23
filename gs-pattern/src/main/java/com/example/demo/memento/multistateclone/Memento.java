package com.example.demo.memento.multistateclone;

import lombok.Data;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
@Data
public class Memento {
    HashMap stateMap;

    public Memento(HashMap stateMap) {
        this.stateMap = stateMap;
    }
}
