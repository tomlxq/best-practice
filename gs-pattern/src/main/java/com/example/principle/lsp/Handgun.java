package com.example.principle.lsp;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Handgun extends AbstractGun {
    //手枪的特点是携带方便，射程短
    @Override
    public void shoot() {
        System.out.println("手枪射击...");
    }
}