package com.example.demo.builder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/29
 */
public class BuilderSelf {
    public Vacation vacation;

    public BuilderSelf(String std) {
        this.vacation = new Vacation(std);
    }

    public BuilderSelf addDay() {
        this.vacation.addDay();
        return this;
    }

    public BuilderSelf buildDay(int i) {
        this.vacation.setVacationDay(i);
        return this;
    }

    public BuilderSelf addHotel(String hotel) {
        this.vacation.setHotel(hotel);
        return this;
    }

    public BuilderSelf addTicket(String ticket) {
        this.vacation.addTicket(ticket);
        return this;
    }

    public BuilderSelf addEvent(String event) {
        this.vacation.addEvent(event);
        return this;
    }

    public Vacation getVacation() {
        return this.vacation;
    }
}
