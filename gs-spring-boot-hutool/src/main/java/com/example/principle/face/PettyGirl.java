package com.example.principle.face;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class PettyGirl implements IGoodBodyGirl, IGreatTemperamentGirl {
    private String name;

    //美女都有名字
    public PettyGirl(String _name) {
        this.name = _name;
    }

    //脸蛋漂亮
    public void goodLooking() {
        System.out.println(this.name + "---脸蛋很漂亮!");
    }

    //气质要好
    public void greatTemperament() {
        System.out.println(this.name + "---气质非常好!");
    }

    //身材要好
    public void niceFigure() {
        System.out.println(this.name + "---身材非常棒!");
    }
}