package com.carrentalspring.controller;

import com.carrentalspring.model.Booking;
import com.carrentalspring.model.Car;
import com.carrentalspring.service.CarService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/list")
    public String listCars(Model model) {

        List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);
        return "allCars";
    }

    @GetMapping("/new")
    public String newCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "carForm";
    }

    @PostMapping("/new")
    public String saveCar(Car car,
                           ModelMap model) {

        carService.saveCar(car);

        model.addAttribute("success", "Car " + car.getLicensePlate() + " registered successfully");
        return "success";
    }

    @PostMapping("/edit")
    public String updateCar(Car car, Model model) {
        carService.updateCar(car);

        model.addAttribute("success", "Car " + car.getLicensePlate() + " updated successfully");
        return "success";

    }

    @PostMapping("/getAvailableCars")
    public String getAvailableCars(String startDate, String endDate, Model model) throws ParseException {

        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<Car> availableCars = carService.getAvailableCars(df.parse(startDate), df.parse(endDate));
        model.addAttribute("availableCars",availableCars);

        return "availableCars";
    }


    @GetMapping("/delete")
    public String deleteCar(Car car,
                             ModelMap model) {

        carService.deleteCar(car);

        model.addAttribute("success", "Car " + car.getLicensePlate() + " deleted successfully");
        return "success";
    }
}
