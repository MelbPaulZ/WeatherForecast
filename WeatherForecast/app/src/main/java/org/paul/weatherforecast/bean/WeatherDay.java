package org.paul.weatherforecast.bean;

import java.io.Serializable;

/**
 * Created by Paul on 19/7/17.
 */

public class WeatherDay implements Serializable {

    private static final long serialVersionUID = -2927116111395333422L;

    private City city;
    private int cnt;
    private OneDay[] list;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public OneDay[] getList() {
        return list;
    }

    public void setList(OneDay[] list) {
        this.list = list;
    }
}
