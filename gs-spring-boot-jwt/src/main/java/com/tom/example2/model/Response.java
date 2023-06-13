package com.tom.example2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    public final static int SUCCESS_CODE = 0;
    public final static String SUCCESS_DESC = "SUCCESS";
    public final static int FAIL_CODE = 1;
    public final static String FAIL_DESC = "FAILED";
    private int code;
    private String desc;
}
