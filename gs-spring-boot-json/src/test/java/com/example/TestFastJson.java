package com.example;

/**
 * ww
 *
 * @author TomLuo
 * @date 2023年05月10日 6:15
 */
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class TestFastJson implements Serializable {
    private static final long serialVersionUID = 337361630075002456L;

    private String id;

    private String name;

    private String gender;

    @JSONField(serialize = false)
    private String phone;

}