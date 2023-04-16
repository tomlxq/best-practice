package com.example.principle.pkwrapper.bridge;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class FilmStar extends AbsStar {
    //默认的电影明星的主要工作是拍电影
    public FilmStar() {
        super(new ActFilm());
    }

    //也可以重新设置一个新职业
    public FilmStar(AbsAction _action) {
        super(_action);
    }

    //细化电影明星的职责
    public void doJob() {
        System.out.println("\n======影星的工作=====");
        super.doJob();
    }
}
