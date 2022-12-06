package com.carrentalspring.service;

import com.carrentalspring.model.Car;

import java.util.Date;
import java.util.List;

public interface CarService {
    void saveCar(Car car);

    void updateCar(Car car);

    void deleteCar(Car car);

    Car getCarById(int id);

    List<Car> getAvailableCars(Date startDate, Date endDate);

    List<Car> getCars();
}

