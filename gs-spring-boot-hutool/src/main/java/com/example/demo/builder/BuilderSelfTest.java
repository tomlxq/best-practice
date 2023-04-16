package com.example.demo.builder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/29
 */
public class BuilderSelfTest {
    public static void main(String[] args) {
        BuilderSelf builder = new BuilderSelf("2019-10-01");
        builder.addTicket("Plane ticket").addEvent("Fly to Destination").
                addEvent("Supper").
                addEvent("Dancing").
                addHotel("Four seasons").
                addDay().
                addTicket("Theme Park").
                addEvent("Bus to Park").
                addEvent("Lunch").
                addHotel("Four seasons").
                addDay().
                addTicket("Plane ticket").
                addEvent("City tour").
                addEvent("Fly to Home");
        builder.getVacation().showInfo();

        builder = new BuilderSelf("2019-10-15");
        builder.addTicket("Plane ticket").
                addEvent("Fly to Destination").
                addEvent("Supper").
                addHotel("Hilton").
                addDay().
                addTicket("Zoo Ticket").
                addEvent("Bus to Zoo").
                addEvent("Feed animals").
                addHotel("Hilton").
                addDay().
                addTicket("Beach").
                addEvent("Swimming").
                addHotel("Home inn").
                addDay().
                addTicket("Plane ticket").
                addEvent("Fly to Home");
        builder.getVacation().showInfo();
    }
}
