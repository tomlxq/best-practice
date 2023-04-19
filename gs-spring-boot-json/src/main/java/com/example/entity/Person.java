package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Person
 *
 * @author TomLuo
 * @date 2023年04月19日 22:34
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
}