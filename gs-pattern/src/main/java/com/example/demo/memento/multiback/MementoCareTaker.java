package com.example.demo.memento.multiback;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
@Getter
@Setter
public class MementoCareTaker {
    private HashMap<String, Memento> backupMap;

    public MementoCareTaker() {
        backupMap = new HashMap<>();
    }

    public void saveBackup(String backName, Memento memento) {
        backupMap.put(backName, memento);
    }

    public Memento saveBackup(String backName) {
        return backupMap.get(backName);
    }
}
