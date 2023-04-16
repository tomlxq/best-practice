package com.example.principle.ocp;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/13
 */
public interface IComputerBook extends IBook {
    //计算机书籍是有一个范围
    public String getScope();
}
