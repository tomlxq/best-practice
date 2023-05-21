package com.tom.example1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * ww
 *
 * @author TomLuo
 * @date 2023年05月13日 4:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
    //状态码
    private int code;
    //提示信息
    private String msg;
    //用户返回给浏览器的数据
    private Map<String,Object> data = new HashMap<>();

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("请求成功！");
        return result;
    }

    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(400);
        result.setMsg("请求失败！");
        return result;
    }

    public static Msg fail(String msg) {
        Msg result = new Msg();
        result.setCode(400);
        result.setMsg(msg);
        return result;
    }

    public Msg(ReturnResult returnResult){
        code = returnResult.getCode();
        msg = returnResult.getMsg();
    }

    public Msg add(String key,Object value) {
        this.getData().put(key, value);
        return this;
    }
}