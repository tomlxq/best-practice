package com.example.demo.builder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/29
 */
public class Builder3d extends AbsBuilder {

    public Builder3d(String std) {
        super(std);
    }

    @Override
    public void buildVacation() {
        addTicket("Plane ticket");
        addEvent("Fly to Destination");
        addEvent("Supper");
        addEvent("Dancing");
        addHotel("Four seasons");
        vacation.addDay();
        addTicket("Theme Park");
        addEvent("Bus to Park");
        addEvent("Lunch");
        addHotel("Four seasons");
        vacation.addDay();
        addTicket("Plane ticket");
        addEvent("City tour");
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
