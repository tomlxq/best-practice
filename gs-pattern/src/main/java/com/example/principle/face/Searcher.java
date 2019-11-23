package com.example.principle.face;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Searcher extends AbstractSearcher {
    public Searcher(IGreatTemperamentGirl _pettyGirl) {
        super(_pettyGirl);
    }

    //展示美女的信息
    public void show() {
        System.out.println("--------美女的信息如下：---------------");
//展示面容
        //super.pettyGirl.goodLooking();
//展示身材
        // super.pettyGirl.niceFigure();
//展示气质
        super.pettyGirl.greatTemperament();
    }
}