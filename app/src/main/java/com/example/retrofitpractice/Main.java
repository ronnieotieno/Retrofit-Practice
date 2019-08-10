package com.example.retrofitpractice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    @Expose
    String Temp;
    @SerializedName("pressure")
    @Expose
    String pressure;

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String temp) {
        Temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "Main{" +
                "Temp='" + Temp + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
