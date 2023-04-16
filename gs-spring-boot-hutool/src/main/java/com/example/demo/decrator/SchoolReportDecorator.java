package com.example.demo.decrator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public abstract class SchoolReportDecorator implements SchoolReport {
    private SchoolReport schoolReport;

    public SchoolReportDecorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    @Override
    public void report() {
        schoolReport.report();
    }

    @Override
    public void sign(String name) {
        schoolReport.sign(name);
    }
}
