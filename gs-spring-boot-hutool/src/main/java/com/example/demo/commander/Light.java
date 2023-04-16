package com.example.demo.commander;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
@Data
public class Light {
    private String name;
    public Light(String name){this.name=name;}

    public void on() {
        System.out.println(this.getName()+" 打开了");
    }
    public void off() {
        System.out.println(this.getName()+" 关闭了");
    }
}
