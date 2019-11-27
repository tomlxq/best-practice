package com.tom.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    int id;
    String name;
    double money;
}
