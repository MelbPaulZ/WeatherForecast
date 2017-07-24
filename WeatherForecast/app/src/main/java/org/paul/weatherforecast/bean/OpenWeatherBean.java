package org.paul.weatherforecast.bean;

import java.io.Serializable;

/**
 * Created by Paul on 18/7/17.
 */

public class OpenWeatherBean implements Serializable{
    private static final long serialVersionUID = 371141456016508255L;
    private Main main;
    private Weather[] weather;
    private String base = "";
    private int visibility = 0;
    private String name;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
