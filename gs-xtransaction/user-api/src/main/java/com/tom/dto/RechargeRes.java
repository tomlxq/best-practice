package com.tom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RechargeRes implements Serializable {
    private static final long serialVersionUID = -4001523296454073592L;
    private String code;
    private String desc;
}
