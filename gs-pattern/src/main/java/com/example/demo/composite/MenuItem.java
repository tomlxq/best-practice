package com.example.demo.composite;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 树叶节点是没有子下级对象的对象，定义参加组合的原始对象行为
 *
 * @author TomLuo
 * @date 2019/10/20
 */
@AllArgsConstructor
@Data
public class MenuItem extends MenuComponent {
    private String name, desc;
    private float price;
    private boolean vegetable;

    @Override
    public void print() {
        System.out.println("菜单：" + this.getName() + " 菜单描述：" + this.getDesc() +
                " 菜单价格：" + this.getPrice() + " 是否素食：" + this.isVegetable());
    }
}
