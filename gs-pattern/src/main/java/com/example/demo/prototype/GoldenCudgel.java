package com.example.demo.prototype;

import lombok.Data;

import java.awt.*;
import java.io.Serializable;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
@Data
public class GoldenCudgel implements Serializable {
    /**
     * 长度
     */
    private float height = 1000;
    /**
     * 直径
     */
    private float diameter = 15;

    private void grow() {
        this.height *= 2;
        this.diameter *= 2;
    }

    private void shrink() {
        this.height /= 2;
        this.diameter /= 2;
    }
}
