package org.paul.weatherforecast.bean;

import java.io.Serializable;

/**
 * Created by Paul on 18/7/17.
 */

public class Main implements Serializable{
//    "main":{"temp":289.5,"humidity":89,"pressure":1013,"temp_min":287.04,"temp_max":292.04},
    private double temp = 0;
    private double humid = 0;
    private double pressure = 0;
    private double tempMin = 0;
    private double temMax = 0;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumid() {
        return humid;
    }

    public void setHumid(double humid) {
        this.humid = humid;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTemMax() {
        return temMax;
    }

    public void setTemMax(double temMax) {
        this.temMax = temMax;
    }
}
