package com.tom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
@XmlRootElement
@Getter
@Setter
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
