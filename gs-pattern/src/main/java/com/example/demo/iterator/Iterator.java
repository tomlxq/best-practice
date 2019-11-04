package com.example.demo.iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();
}
