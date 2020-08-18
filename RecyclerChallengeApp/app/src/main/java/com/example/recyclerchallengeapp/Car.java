package com.example.recyclerchallengeapp;

public class Car {

    private String make;
    private String model;
    private String owner;
    private String phone;

    public Car(String make, String model, String owner, String phone) {
        this.make = make;
        this.model = model;
        this.owner = owner;
        this.phone = phone;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
