package com.carrentalspring.service;

import java.util.List;

import com.carrentalspring.model.Car;

public interface CarService {
    void saveCar(Car car);
    void updateCar(Car car);
    void deleteCar(Car car);

    Car getCarById(int id);
    List<Car> getCars();
}
