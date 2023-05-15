package com.guide.easyexcel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/28
 */
@Data
@AllArgsConstructor
public class Member {
    Long id;
    String name;
    Integer age;
}
