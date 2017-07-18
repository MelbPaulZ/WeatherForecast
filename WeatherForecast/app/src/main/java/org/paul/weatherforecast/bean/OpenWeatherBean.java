package org.paul.weatherforecast.bean;

/**
 * Created by Paul on 18/7/17.
 */

public class OpenWeatherBean {
    private Main main;
    private Weather[] weather;
    private String base = "";
    private int visibility = 0;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
