package com.example.demo.rest;

import com.example.demo.entity.Car;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController @RequestMapping("api")
public class CarController {

    List<Car> carList;

    @PostConstruct
    public void loadData() {

        carList = new ArrayList<>();

        carList.add( new Car(1, "Mazda", "RX-7"));
        carList.add( new Car(2, "Mitsubishi", "Lancer Evo V"));
        carList.add( new Car(3, "Toyota", "Yaris/Vitz"));

    }

    @GetMapping("/cars")
    public List<Car> allCars() { return carList; }

    @GetMapping("/cars/{carId}")
    public Car getCar(@PathVariable int carId) {

        for (Car car: this.carList) {

            if (car.getId() == carId) { return car; }

        } return null;

    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car newCar) {

        carList.add(newCar);

        return newCar;

    }

    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car theCar) {

        for (Car car : carList) {

            if (car.getId() == theCar.getId()) {

                car.setManufacter(theCar.getManufacter());
                car.setModel(theCar.getModel());

            }

        } return theCar;

    }

    @DeleteMapping("/cars/{carId}")
    public String deleteCar(@PathVariable int carId) {

        this.carList.removeIf(c -> c.getId() == carId);

        return "Coche con ID: " + carId + " eliminado.";

    }

}
