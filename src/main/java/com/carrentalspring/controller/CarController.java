package com.carrentalspring.controller;

import com.carrentalspring.model.Booking;
import com.carrentalspring.model.Car;
import com.carrentalspring.model.User;
import com.carrentalspring.service.CarService;
import com.carrentalspring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final UserService userService;

    public CarController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
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
    public String getAvailableCars(@ModelAttribute("booking")Booking booking, @RequestParam("userId")int userId, Model model) throws ParseException {

        User user = userService.getUser(userId);
        String username = user.getUsername();
        booking.setUser(user);
        List<Car> availableCars = carService.getAvailableCars(booking.getStartDate(),booking.getEndDate());
        model.addAttribute("availableCars",availableCars);
        model.addAttribute("username", username);

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
