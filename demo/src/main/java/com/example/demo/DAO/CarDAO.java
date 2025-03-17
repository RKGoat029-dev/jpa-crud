package com.example.demo.DAO;

import com.example.demo.entity.Car;

public interface CarDAO {

    void save(Car car);

    Car findById(int id);

}
