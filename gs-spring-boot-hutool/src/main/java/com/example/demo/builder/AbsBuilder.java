package com.example.demo.builder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/29
 */
public abstract class AbsBuilder {
    public Vacation vacation;

    public AbsBuilder(String std) {
        vacation = new Vacation(std);
    }

    public abstract void buildVacation();

    public abstract void buildDay(int i);

    public abstract void addHotel(String hotel);

    public abstract void addTicket(String ticket);

    public abstract void addEvent(String event);

    public Vacation getVacation() {
        return vacation;
    }
}
