package com.tom.entity;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/5
 */
@Getter
@Setter
public class Person implements Serializable {
    private static final long serialVersionUID = -5589768728813879975L;
    @Protobuf(fieldType = FieldType.STRING)
    private String name;
    @Protobuf(fieldType = FieldType.INT32)
    private int age;
    /**
     * 序列化并不能保存静态变量的状态
     */
    public static int height = 2;
    /**
     * transient不参与序列化
     */
    private transient Date birthday;
}
