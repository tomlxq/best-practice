package com.example.principle.pkwrapper.decorator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Client {
    public static void main(String[] args) {
        IStar star = new FreakStar();
        HotStar hotStar = new HotStar(star);
        DenyStar denyStar = new DenyStar(hotStar);
        denyStar.act();
    }
}
