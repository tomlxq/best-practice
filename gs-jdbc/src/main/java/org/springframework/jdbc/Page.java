package org.springframework.jdbc;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/11
 */
@Data
public class Page<T> implements Serializable {
    public static final int DEFAULT_OFFSET = 20;
    int pageSize= DEFAULT_OFFSET;
    long start;
    long total;
    List<T> list;
}
