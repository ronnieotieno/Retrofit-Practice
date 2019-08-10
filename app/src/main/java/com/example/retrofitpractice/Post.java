package com.example.retrofitpractice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Post {

    //private int userId;
   // private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("weather")
    @Expose
    private ArrayList<WeatherMain> weatherMains;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id =id;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public ArrayList<WeatherMain> getWeatherMains() {
        return weatherMains;
    }

    public void setWeatherMains(ArrayList<WeatherMain> weatherMains) {
        this.weatherMains = weatherMains;
    }

    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", main=" + main +
                ", weatherMains=" + weatherMains +
                '}';
    }
}


