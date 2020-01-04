package com.tom.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/1
 */
@Data
@NoArgsConstructor
public class DoOrderResponse implements Serializable {
    private static final long serialVersionUID = 4038461615509714712L;

    public DoOrderResponse(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    private String code;
    private String desc;
    private Object data;
}
