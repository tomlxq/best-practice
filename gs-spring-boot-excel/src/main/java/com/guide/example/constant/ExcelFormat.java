package com.guide.example.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ExcelFormat
 *
 * @author TomLuo
 * @date 2023年05月14日 18:32
 */
@AllArgsConstructor
@Getter
public enum ExcelFormat {

    FORMAT_INTEGER("INTEGER"),
    FORMAT_DOUBLE("DOUBLE"),
    FORMAT_PERCENT("PERCENT"),
    FORMAT_DATE("DATE");

    private String value;


}