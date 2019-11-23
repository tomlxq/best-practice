package com.example.principle.pkdecoratoradapter.decorator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class BeautifyAppearance extends Decorator {
    //要美化谁
    public BeautifyAppearance(Swan _swan) {
        super(_swan);
    }

    //外表美化处理
    @Override
    public void desAppearance() {
        System.out.println("外表是纯白色的，非常惹人喜爱！");
    }
}
