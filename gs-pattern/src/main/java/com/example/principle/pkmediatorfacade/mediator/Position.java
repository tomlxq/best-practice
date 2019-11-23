package com.example.principle.pkmediatorfacade.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Position extends AbsColleague implements IPosition {
    public Position(AbsMediator _mediator) {
        super(_mediator);
    }

    public void demote() {
        super.mediator.down(this);
    }

    public void promote() {
        super.mediator.up(this);
    }
}
