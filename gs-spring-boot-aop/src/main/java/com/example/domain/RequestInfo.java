package com.example.domain;

import lombok.Data;

/**
 * RequestInfo
 *
 * @author TomLuo
 * @date 2023年05月11日 5:38
 */
@Data
public class RequestInfo {
    private String ip;
    private String url;
    private String httpMethod;
    private String classMethod;
    private Object requestParams;
    private Object result;
    private Long timeCost;
}