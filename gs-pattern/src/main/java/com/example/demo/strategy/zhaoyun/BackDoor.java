package com.example.demo.strategy.zhaoyun;

import javax.swing.text.html.HTMLDocument;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/11
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("乔国老开后门");
    }
}
