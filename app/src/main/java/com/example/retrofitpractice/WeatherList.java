package com.example.retrofitpractice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherList {

    @SerializedName("list")
    @Expose
    ArrayList<Post> weather;

    public ArrayList<Post> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Post> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherList{" +
                "weather=" + weather +
                '}';
    }
}
