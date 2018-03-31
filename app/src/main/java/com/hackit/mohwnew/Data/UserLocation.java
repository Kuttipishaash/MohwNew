package com.hackit.mohwnew.Data;

public class UserLocation {
    private double lat;
    private double lng;

    public UserLocation(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public UserLocation() {
    }

    public double getLat() {

        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
