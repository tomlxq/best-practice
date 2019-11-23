package com.example.principle.pkmediatorfacade.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Salary extends AbsColleague implements ISalary {
    public Salary(AbsMediator _mediator) {
        super(_mediator);
    }

    @Override
    public void decreaseSalary() {
        super.mediator.down(this);
    }

    @Override
    public void increaseSalary() {
        super.mediator.up(this);
    }
}