package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 鑫
 *
 * @author TomLuo
 * @date 2023年04月06日 0:29
 */
@AllArgsConstructor
@Getter
public enum  AppCode implements StatusCode {

    APP_ERROR(2000, "业务异常"),
    PRICE_ERROR(2001, "价格异常");

    private int code;
    private String msg;


}