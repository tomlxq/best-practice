package com.guide.easyexcel.service;

import java.io.IOException;

/**
 * ExcelService
 *
 * @author TomLuo
 * @date 2023年03月20日 6:14
 */
public interface ExcelService {
    void createExcelByDivide10w();

    String createExcelByPage(int page) throws InterruptedException, IOException;
}
