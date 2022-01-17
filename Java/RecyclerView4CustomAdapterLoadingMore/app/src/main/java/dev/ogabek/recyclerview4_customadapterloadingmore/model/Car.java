package dev.ogabek.recyclerview4_customadapterloadingmore.model;

import android.content.Context;

public class Car {

    private Context context;
    private int carPhoto;
    private String carName;
    private double price;

    public Car(int carPhoto, String carName, double price) {
        this.carPhoto = carPhoto;
        this.carName = carName;
        this.price = price;
    }

    public Context getContext() {
        return context;
    }
    public int getCarPhoto() {
        return carPhoto;
    }
    public String getCarName() {
        return carName;
    }
    public double getPrice() {
        return price;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
    public void setCarPhoto(int carPhoto) {
        this.carPhoto = carPhoto;
    }
    public void setContext(Context context) {
        this.context = context;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
