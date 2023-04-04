package com.example;

import com.aspose.pdf.*;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * TestPDF
 *
 * @author TomLuo
 * @date 2023年03月18日 9:28
 */
public class TestPDF {
    @Test
    void name() throws IOException {
        convertPDFtoXLSX("D:\\聚金\\招商银行交易流水(2015-01-01 -- 2016-12-01).pdf");
        convertPDFtoXLSX("D:\\聚金\\招商银行交易流水(2016-12-01 -- 2018-12-01).pdf");

    }



    private static void convertPDFtoXLSX(String dataDir) {
        Document doc = new Document(dataDir);
        // Initialize ExcelSaveOptions
        ExcelSaveOptions options = new ExcelSaveOptions();
        // Set output format
        options.setFormat(ExcelSaveOptions.ExcelFormat.XLSX);
        // Save output file

        doc.save( dataDir.replace(FilenameUtils.getExtension(dataDir),".xlsx"), options);
    }
}