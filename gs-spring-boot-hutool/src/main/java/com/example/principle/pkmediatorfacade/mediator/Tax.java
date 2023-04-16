package com.example.principle.pkmediatorfacade.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Tax extends AbsColleague implements ITax {
    //注入中介者
    public Tax(AbsMediator _mediator) {
        super(_mediator);
    }

    public void drop() {
        super.mediator.down(this);
    }

    public void raise() {
        super.mediator.up(this);
    }
}
