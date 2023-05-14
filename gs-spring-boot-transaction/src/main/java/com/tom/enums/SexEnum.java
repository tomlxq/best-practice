package com.tom.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * q
 *
 * @author TomLuo
 * @date 2023年05月14日 9:55
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum SexEnum implements IEnum<Integer> {
    MAN(1, "男"),
    WOMAN(2, "女");
    private Integer code;
    private String name;
    @Override
    public Integer getValue() {
        return code;
    }
}
