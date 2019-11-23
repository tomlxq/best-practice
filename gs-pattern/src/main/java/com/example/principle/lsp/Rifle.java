package com.example.principle.lsp;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Rifle extends AbstractGun {
    //步枪的特点是射程远，威力大
    public void shoot() {
        System.out.println("步枪射击...");
    }
}
