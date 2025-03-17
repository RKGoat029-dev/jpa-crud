package com.example.demo.entity;

public class Car {

    private String manufacter;
    private String model;

    public Car() {}

    public Car(
            String manufacter,
            String model
    ) {
        this.manufacter = manufacter;
        this.model = model;
    }

    public String getManufacter() { return this.manufacter; }

    public void setManufacter( String manufacter ) { this.manufacter = manufacter; }

    public String getModel() { return this.model; }

    public void setModel( String model ) { this.model = model; }

}
