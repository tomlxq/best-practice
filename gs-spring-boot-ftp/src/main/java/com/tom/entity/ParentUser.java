package com.tom.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 子类不参与序列化，如果没有实现Serializable
 *
 * @author TomLuo
 * @date 2019/12/5
 */
@Getter
@Setter
public class ParentUser {
    private int age;
}
