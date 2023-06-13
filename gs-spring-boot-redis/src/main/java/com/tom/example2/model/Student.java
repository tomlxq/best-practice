package com.tom.example2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Student
 *
 * @author TomLuo
 * @date 2023年04月22日 18:01
 */
@Data
@RedisHash("Student")
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    public enum Gender {
        MALE, FEMALE
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;}