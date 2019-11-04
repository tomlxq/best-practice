package com.example.demo.builder;

import java.util.ArrayList;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/29
 */
public class VacationDay {
    private Date date;
    private String hotel;
    private ArrayList<String> tickets = null;
    private ArrayList<String> events = null;

    public VacationDay(Date date) {
        this.date = date;
        tickets = new ArrayList<>();
        events = new ArrayList<>();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void addTicket(String ticket) {
        tickets.add(ticket);
    }

    public void addEvent(String event) {
        events.add(event);
    }

    public String showInfo() {
        StringBuffer stb = new StringBuffer();
        stb.append("Date :" + date.toString() + "\n");
        stb.append("Hotel :" + hotel + "\n");
        stb.append("Tickets :" + tickets.toString() + "\n");
        stb.append("Events :" + events.toString() + "\n");
        return stb.toString();
    }
}
