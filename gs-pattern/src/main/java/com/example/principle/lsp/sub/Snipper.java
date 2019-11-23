package com.example.principle.lsp.sub;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
@Data
public class Snipper {
    private AUG rifle;

    public void killEnemy(/*AUG aug*/) {
//首先看看敌人的情况，别杀死敌人，自己也被人干掉
        rifle.zoomOut();
//开始射击
        rifle.shoot();
    }

    // public void setRifle(AUG aug) {
    // }
}