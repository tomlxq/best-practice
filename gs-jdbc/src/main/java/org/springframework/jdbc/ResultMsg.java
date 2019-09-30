package org.springframework.jdbc;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/11
 */
@Data
public class ResultMsg<T> implements Serializable {
    /**
     * 状态码
     */
    String code;
    /**
     * 返回消息
     */
    String msg;
    /**
     * 数据
     */
    T data;
}
