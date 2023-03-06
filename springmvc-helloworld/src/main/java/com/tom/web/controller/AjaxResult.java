package com.tom.web.controller;


import com.alibaba.fastjson2.JSON;
import lombok.Builder;
import lombok.Data;

/**
 * AjaxResult
 *
 * @author TomLuo
 * @date 2023年03月01日 21:04
 */
@Builder
@Data
public class AjaxResult {
    private int status;
    private String content;

    public static <T> AjaxResult success(T t) {
        return AjaxResult.builder()
                .content(JSON.toJSON(t).toString())
                .status(0).build();
    }
}