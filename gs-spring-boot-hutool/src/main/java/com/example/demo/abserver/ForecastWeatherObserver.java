package com.example.demo.abserver;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class ForecastWeatherObserver implements Observer {
    private int temperature;
    private int humidity;
    private int pressure;

    @Override
    public void update(int temperature,
                       int humidity,
                       int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    private void display() {
        System.out.println("明天天气温度：" + temperature);
        System.out.println("明天天气显度：" + humidity);
        System.out.println("明天天气气压：" + pressure);
    }
}
