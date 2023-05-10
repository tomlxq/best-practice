package com.example.condition;

/**
 * Strategy 策略类的公共接口
 *
 * @author TomLuo
 * @date 2023年04月28日 21:22
 */
public abstract class Strategy {
    /**
     * 定义支持所有算法的公共接口
     *
     * @return
     */
    public abstract String query();
}