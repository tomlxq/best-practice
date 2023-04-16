package com.example.demo.abserver;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
@Data
public class WeatherData implements Subject {
    List<Observer> observerList;
    private int temperature;
    private int humidity;
    private int pressure;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer obs) {
        observerList.add(obs);
    }

    @Override
    public void deleteObserver(Observer obs) {
        if (observerList.contains(obs)) {
            observerList.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(obs -> {
            obs.update(this.getTemperature(), this.getHumidity(), this.getPressure());
        });
    }

    public void setData(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public void dataChange() {
        notifyObservers();
    }
}
