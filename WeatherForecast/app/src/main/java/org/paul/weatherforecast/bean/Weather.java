package org.paul.weatherforecast.bean;

import java.io.Serializable;

/**
 * Created by Paul on 18/7/17.
 */

public class Weather implements Serializable{
//    "weather":[{"id":804,"main":"clouds","description":"overcast clouds","icon":"04n"}],
    private int id = 0;
    private String main = "";
    private String description = "";
    private String icon = "";

    public Weather(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }
}
