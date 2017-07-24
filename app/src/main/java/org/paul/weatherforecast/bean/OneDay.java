package org.paul.weatherforecast.bean;

import java.io.Serializable;

/**
 * Created by Paul on 19/7/17.
 */

public class OneDay implements Serializable{
    private Temp temp;
    private double pressure = 0.0;
    private double humidity = 0.0;
    private Weather[] weather;

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }
}
