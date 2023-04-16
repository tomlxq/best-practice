package com.example.principle.pkmediatorfacade.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public abstract class AbsColleague {
    //每个同事类都对中介者非常了解
    protected AbsMediator mediator;

    public AbsColleague(AbsMediator _mediator) {
        this.mediator = _mediator;
    }
}
