package com.example.demo.memento.multistateclone;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
@Setter
@Getter
public class Originator implements Cloneable {
    //内部状态
    private String state1;
    private String state2;
    private String state3;

    //创建一个备忘录
    public Memento createMemento() {
        return new Memento(BeanUtils.backProp(this));
    }

    //恢复一个备忘录
    public void restoreMemento(Memento memento) {
        BeanUtils.restoreProp(this, memento.getStateMap());
    }

    public void showState() {
        System.out.println(JSON.toJSONString(this, true));
    }


}
