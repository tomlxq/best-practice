package com.example.principle.lsp.sub;

import com.example.principle.lsp.Rifle;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class AUG extends Rifle {
    //狙击枪都携带一个精准的望远镜
    public void zoomOut() {
        System.out.println("通过望远镜察看敌人...");
    }

    public void shoot() {
        System.out.println("AUG射击...");
    }
}