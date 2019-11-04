package com.example.demo.builder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/29
 */
public class Builder4d extends AbsBuilder {

    public Builder4d(String std) {
        super(std);
    }

    @Override
    public void buildVacation() {

        addTicket("Plane ticket");
        addEvent("Fly to Destination");
        addEvent("Supper");
        addHotel("Hilton");
        vacation.addDay();
        addTicket("Zoo Ticket");
        addEvent("Bus to Zoo");
        addEvent("Feed animals");
        addHotel("Hilton");
        vacation.addDay();
        addTicket("Beach");
        addEvent("Swimming");
        addHotel("Home inn");
        vacation.addDay();
        addTicket("Plane ticket");
        addEvent("Fly to Home");
    }

    @Override
    public void buildDay(int i) {
        vacation.setVacationDay(i);
    }

    @Override
    public void addHotel(String hotel) {
        vacation.setHotel(hotel);
    }

    @Override
    public void addTicket(String ticket) {
        vacation.addTicket(ticket);
    }

    @Override
    public void addEvent(String event) {
        vacation.addEvent(event);
    }
}
