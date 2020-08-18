package com.example.recyclerchallengeapp;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Car> vehicle;

    @Override
    public void onCreate() {
        super.onCreate();

        vehicle = new ArrayList<>();
        vehicle.add(new Car("Volkswagen", "Polo", "Jim Halpert", "9634107618"));
        vehicle.add(new Car("Nissan", "Almera", "Pam Halpert", "8882121897"));
        vehicle.add(new Car("Mercedes", "E320", "Michael Scott", "9616313491"));
        vehicle.add(new Car("Mercedes", "E180", "David Wallace", "96341013616"));
        vehicle.add(new Car("Nissan", "City", "Andy Bernard", "9634107618"));
        vehicle.add(new Car("Volkswagen", "Vento", "Dwight Schrutte", "9163194799"));
        vehicle.add(new Car("Mercedes", "S300", "Robert California", "9619413496"));
        vehicle.add(new Car("Nissan", "Rapid", "Phyllis Vance", "6461979196"));


    }
}
