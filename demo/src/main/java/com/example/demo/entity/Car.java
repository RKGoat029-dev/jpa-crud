package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "manufacter")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    public Car() {}

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public String getManufacturer() { return this.manufacturer; }

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getModel() { return this.model; }

    public void setModel(String model) { this.model = model; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}