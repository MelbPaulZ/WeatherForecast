package org.paul.weatherforecast.bean;

/**
 * Created by Paul on 19/7/17.
 */

public class Temp {
    private double day = 0.0;
    private double min = 0.0;
    private double max = 0.0;
    private double night = 0.0;
    private double eve = 0.0;
    private double morn = 0.0;

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }
}

