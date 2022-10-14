package com.carrentalspring.controller;

import com.carrentalspring.model.Booking;
import com.carrentalspring.model.Car;
import com.carrentalspring.model.User;
import com.carrentalspring.security.CustomUserDetails;
import com.carrentalspring.service.CarService;
import com.carrentalspring.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping("/save")
    public String saveCar(Car car,
                           Model model) {

        carService.saveCar(car);

        model.addAttribute("success", "Car " + car.getLicensePlate() + " registered successfully.");
        return "success";
    }

    @GetMapping("/getEdit")
    public String editCar(@RequestParam("carId")int carId, Model model) {

        Car existingCar = carService.getCarById(carId);
        model.addAttribute("car", existingCar);

        return "carForm";

    }
    @PostMapping("/edit")
    public String updateCar(Car car, Model model) {
        carService.updateCar(car);

        model.addAttribute("success", "Car " + car.getLicensePlate() + " updated successfully");
        return "success";

    }

    @PostMapping("/getAvailableCars")
    public String getAvailableCars(@ModelAttribute("booking")Booking booking, @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("startDate")Date startDate, @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("endDate")Date endDate, Model model) {

        CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(currentUser.getId());
        String username = user.getUsername();
        booking.setUser(user);
        List<Car> availableCars = carService.getAvailableCars(booking.getStartDate(),booking.getEndDate());
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("availableCars",availableCars);
        model.addAttribute("username", username);

        return "availableCars";
    }




    @GetMapping("/delete")
    public String deleteCar( @RequestParam("carId")int carId,
                             Model model) {

        Car car = carService.getCarById(carId);
        carService.deleteCar(car);


        return listCars(model);
    }
}
