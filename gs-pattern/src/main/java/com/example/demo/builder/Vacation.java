package com.example.demo.builder;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/29
 */
public class Vacation {
    private ArrayList<VacationDay> vacationDays;
    private Date date;
    private int days = 0;
    private VacationDay vacationDay;

    public Vacation(String std) {
        vacationDays = new ArrayList<>();
        try {
            date = DateUtils.parseDate(std, "yyyy-MM-dd");
            vacationDay = new VacationDay(date);
            vacationDays.add(vacationDay);
            days++;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String std) {
        try {
            this.date = DateUtils.parseDate(std, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void addDay() {
        vacationDay = new VacationDay(nextDay(days));
        vacationDays.add(vacationDay);
        days++;
    }

    private Date nextDay(int days) {
        return DateUtils.addDays(date, days);
    }

    public boolean setVacationDay(int i) {
        if (i > 0 && i < vacationDays.size()) {
            vacationDay = vacationDays.get(i);
        }
        vacationDay = null;
        return false;
    }

    public void setHotel(String hotel) {
        vacationDay.setHotel(hotel);
    }

    public void addTicket(String ticket) {
        vacationDay.addTicket(ticket);
    }

    public void addEvent(String event) {
        vacationDay.addEvent(event);
    }

    public void showInfo() {
        for (int i = 0, len = vacationDays.size(); i < len; i++) {
            System.out.println("** " + (i + 1) + " day**");
            System.out.println(vacationDays.get(i).showInfo());
        }
    }
}
