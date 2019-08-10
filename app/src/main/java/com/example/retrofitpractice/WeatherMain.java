package com.example.retrofitpractice;

public class WeatherMain {
    private String description;
    private String main;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "WeatherMain{" +
                "description='" + description + '\'' +
                ", main='" + main + '\'' +
                '}';
    }
}
