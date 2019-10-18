package com.example.demo.decrator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class SchoolReportTest {
    public static void main(String[] args) {
        SchoolReport schoolReport = new TomSchoolReport();
        System.out.println("~~~~~~~~~~~~这个成绩打屁股打定了~~~~~~~~~~~~");
        schoolReport.report();
        schoolReport.sign("Dad");
        schoolReport  =new HighScoreDecorator(schoolReport);
        schoolReport  =new RankingDecorator(schoolReport);
        System.out.println("~~~~~~~~~~~~看起来不错，老爸很高兴！~~~~~~~~~~~~");
        schoolReport.report();
        schoolReport.sign("Dad");
    }
}
