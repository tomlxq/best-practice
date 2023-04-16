package com.example.demo.abserver.javaapi;


import java.util.Observable;
import java.util.Observer;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class CurrentWeatherObserver implements Observer {
    private int temperature;
    private int humidity;
    private int pressure;



    private void display() {
        System.out.println("今天天气温度：" + temperature);
        System.out.println("今天天气显度：" + humidity);
        System.out.println("今天天气气压：" + pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.temperature = ((WeatherData.Data)arg).getTemperature();
        this.humidity = ((WeatherData.Data)arg).getHumidity();;
        this.pressure = ((WeatherData.Data)arg).getPressure();;
        display();
    }
}
