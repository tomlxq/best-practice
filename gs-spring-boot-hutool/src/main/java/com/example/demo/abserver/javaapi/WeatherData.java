package com.example.demo.abserver.javaapi;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
@Data
public class WeatherData extends Observable {

    private int temperature;
    private int humidity;
    private int pressure;


    @Override
    public void notifyObservers() {
        this.setChanged();
        this.notifyObservers(new Data(this.getTemperature(), this.getHumidity(), this.getPressure()));

    }


    public void dataChange() {
        this.setChanged();
        notifyObservers();
    }
    public void setData(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }
    @AllArgsConstructor
    @lombok.Data
    class Data {
        private int temperature;
        private int humidity;
        private int pressure;
    }
}
