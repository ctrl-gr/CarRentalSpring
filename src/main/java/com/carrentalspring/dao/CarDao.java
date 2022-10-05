package com.carrentalspring.dao;

import java.util.List;

import com.carrentalspring.model.Car;

public interface CarDao {
    Car getCarById(int id);
    void saveCar(Car car);
    void deleteCar(Car car);
    List<Car> getCars();
}
