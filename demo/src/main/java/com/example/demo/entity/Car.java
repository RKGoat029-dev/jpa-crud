package com.example.demo.entity;


import jakarta.persistence.*;

@Entity @Table(name = "car")
public class Car {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "manufacter")
    private String manufacter;

    @Column(name = "model")
    private String model;

    public Car() {}

    public Car(
            int id,
            String manufacter,
            String model
    ) {
        this.id = id;
        this.manufacter = manufacter;
        this.model = model;
    }

    public String getManufacter() { return this.manufacter; }

    public void setManufacter( String manufacter ) { this.manufacter = manufacter; }

    public String getModel() { return this.model; }

    public void setModel( String model ) { this.model = model; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacter='" + manufacter + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

}
