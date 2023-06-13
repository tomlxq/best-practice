package com.example.enumdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 枚举抽象方法
 * 枚举类可以定义抽象方法，然后让各个具体的枚举实现，可以通过枚举实现不同的策略实现。
 *
 * @author TomLuo
 * @date 2023年06月06日 5:11
 */
@AllArgsConstructor
public enum OperEnum {
    ADD(1, 2) {
        @Override
        public Integer operate() {
            return this.getA() + this.getB();
        }
    }, MULTIPY(1, 2) {
        @Override
        public Integer operate() {
            return this.getA() * this.getB();
        }
    };
    @Getter
    @Setter
    private Integer a;
    @Getter
    @Setter
    private Integer b;
    public abstract Integer operate();


}