package com.example.retrofitpractice;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

public class PostDisplay {
    String city;
    String temp;
    String id;
    String desc;
    int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCity() {
        return city;
    }

    public String getTemp() {
        return temp;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(View view, int image) {

        ImageView imageView = (ImageView) view;
        imageView.setImageResource(image);

    }
}
