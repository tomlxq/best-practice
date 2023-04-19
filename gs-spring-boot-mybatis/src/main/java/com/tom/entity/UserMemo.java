package com.tom.entity;


import lombok.Data;
/**
 * UserMemo
 *
 * @author TomLuo
 * @date 2023年04月19日 23:14
 */
@Data
public class UserMemo {
    private Long userId;
    private String content;
}