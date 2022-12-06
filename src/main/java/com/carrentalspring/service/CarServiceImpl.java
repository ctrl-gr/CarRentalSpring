package com.carrentalspring.service;


import com.carrentalspring.dao.CarDao;
import com.carrentalspring.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public void saveCar(Car car) {
        carDao.saveCar(car);
    }

    @Override
    @Transactional
    public void updateCar(Car car) {
        Car entity = carDao.getCarById(car.getId());
        if (entity != null) {
            car.setLicensePlate(car.getLicensePlate());
            car.setManufacturer(car.getManufacturer());
            car.setModel(car.getModel());
            car.setType(car.getType());
            car.setYear(car.getYear());
            car.setSeats(car.getSeats());
        }
        carDao.saveCar(entity);
    }

    @Override
    @Transactional
    public Car getCarById(int id) {
        return carDao.getCarById(id);
    }

    @Override
    @Transactional
    public void deleteCar(Car car) {
        carDao.deleteCar(car);
    }


    @Override
    @Transactional
    public List<Car> getAvailableCars(Date startDate, Date endDate) {

        return carDao.getAvailableCars(startDate, endDate);
    }


    @Override
    @Transactional
    public List<Car> getCars() {
        return carDao.getCars();
    }
}