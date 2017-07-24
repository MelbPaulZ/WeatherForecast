package org.paul.weatherforecast.bean;

import java.io.Serializable;

/**
 * Created by Paul on 19/7/17.
 */

public class City implements Serializable {

    private static final long serialVersionUID = -55587308962443394L;

    private int geonameId;
    private String name = "";
    private double lat = 0.0;
    private double lon = 0.0;
    private String country = "";

    public int getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(int geonameId) {
        this.geonameId = geonameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
