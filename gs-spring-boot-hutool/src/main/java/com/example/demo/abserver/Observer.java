package com.example.demo.abserver;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public interface Observer {
    void update(int temperature,
                int humidity,
                int pressure);
}
