package com.example.demo.DAO;

import com.example.demo.entity.Car;
import java.util.List;

public interface CarDAO {

    void save(Car car);

    Car findById(int id);

    List<Car> findAll();

    List<Car> findByManufacter(String manufacter);

    List<Car> findByModel(String model);

}
