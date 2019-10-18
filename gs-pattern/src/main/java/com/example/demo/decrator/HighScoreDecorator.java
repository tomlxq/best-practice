package com.example.demo.decrator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class HighScoreDecorator extends SchoolReportDecorator {
    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    @Override
    public void report() {
        System.out.println("班上最高分 语文 25 数学 79 外语 85");
        super.report();
    }
}
