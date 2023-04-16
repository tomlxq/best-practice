package com.example.demo.decrator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class RankingDecorator extends SchoolReportDecorator {
    public RankingDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    @Override
    public void report() {
        super.report();
        System.out.println("总体排名还不错 第15名");
    }
}
