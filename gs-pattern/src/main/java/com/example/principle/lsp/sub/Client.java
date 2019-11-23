package com.example.principle.lsp.sub;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Client {
    public static void main(String[] args) {
//产生三毛这个狙击手
        Snipper sanMao = new Snipper();
        sanMao.setRifle(new AUG());
        //sanMao.setRifle((AUG)(new Rifle()));
        sanMao.killEnemy();
    }
}
