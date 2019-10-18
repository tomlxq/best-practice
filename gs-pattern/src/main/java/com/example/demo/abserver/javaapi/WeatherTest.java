package com.example.demo.abserver.javaapi;


import java.util.Observer;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class WeatherTest {
    public static void main(String[] args) {
        Observer today = new CurrentWeatherObserver();
        Observer tomorrow = new ForecastWeatherObserver();
        WeatherData weatherData = new WeatherData();
        weatherData.addObserver(today);
        weatherData.addObserver(tomorrow);
        weatherData.setData(150, 230, 180);
        weatherData.dataChange();
        System.out.println("#############移除观察者#############");
        weatherData.deleteObserver(today);
        weatherData.setData(120, 150, 100);
        weatherData.dataChange();
    }
}
