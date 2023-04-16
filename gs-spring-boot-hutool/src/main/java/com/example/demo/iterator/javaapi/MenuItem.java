package com.example.demo.iterator.javaapi;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
@Data
@AllArgsConstructor
public class MenuItem {
    private String name, desc;
    private float price;
    private boolean vegetable;
}
