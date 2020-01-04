package com.tom.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class DoOrderRequest implements Serializable {
    private static final long serialVersionUID = 6777309018108990724L;
    private String name;
}
