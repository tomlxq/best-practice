package com.example.demo.abserver;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public interface Subject {
    void addObserver(Observer obs);
    void deleteObserver(Observer obs);
    void notifyObservers();
}
