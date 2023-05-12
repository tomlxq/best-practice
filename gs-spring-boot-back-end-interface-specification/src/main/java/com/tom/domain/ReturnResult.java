package com.tom.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ReturnResult
 *
 * @author TomLuo
 * @date 2023年05月13日 5:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResult<T> {
    private int code;
    private String msg;
}