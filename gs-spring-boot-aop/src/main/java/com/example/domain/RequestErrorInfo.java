package com.example.domain;

import lombok.Data;

/**
 * RequestErrorInfo
 *
 * @author TomLuo
 * @date 2023年05月11日 5:41
 */
@Data
public class RequestErrorInfo {
    private String ip;
    private String url;
    private String httpMethod;
    private String classMethod;
    private Object requestParams;
    private RuntimeException exception;
}
