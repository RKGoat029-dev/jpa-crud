package com.example.demo.DAO;

import com.example.demo.entity.Car;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CarDAO {

    void save(Car car);

    Car findById(int id);

    List<Car> findAll();

    List<Car> findByManufacturer(String manufacturer);

    List<Car> findByModel(String model);

    void update(Car car);

    void delete(int id);

}
