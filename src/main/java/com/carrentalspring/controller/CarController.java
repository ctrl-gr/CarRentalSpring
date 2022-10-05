package com.carrentalspring.controller;

import com.carrentalspring.model.Car;
import com.carrentalspring.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @RequestMapping(value= "/list", method = RequestMethod.GET)
    public String listCars(ModelMap model) {

        List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);
        return "allCars";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newCar(ModelMap model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "carForm";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveCar(Car car,
                           ModelMap model) {

        carService.saveCar(car);

        model.addAttribute("success", "Car " + car.getLicensePlate() + " registered successfully");
        return "success";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String updateCar(Car car, Model model) {
        carService.updateCar(car);

        model.addAttribute("success", "Car " + car.getLicensePlate() + " updated successfully");
        return "success";

    }
/*
    @RequestMapping(value = {"/getAvailableCars"}, method = RequestMethod.POST)
    public String getAvailableCars(@RequestParam (value="username") String username, @DateTimeFormat(pattern="dd-MM-yyyy") @RequestParam(value="startDate") Date startDate, @RequestParam(value ="endDate") Date endDate, Model model) {

        model.addAttribute("username");
        model.addAttribute("startDate");
        model.addAttribute("endDate");
        return "availableCars";
    }
*/

 /*
    @RequestMapping(value = {"/showAvailableCars"}, method = RequestMethod.POST)
    public String showAvailableCars(@RequestParam (value="username") String username, @RequestParam (value="startDate") @DateTimeFormat(pattern="dd-MM-yyyy") Date startDate, @RequestParam(value ="endDate") Date endDate) {
        carService.getAvailableCars(startDate, endDate);
        return "availableCars";
    }

 */


    @RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
    public String deleteCar(Car car,
                             ModelMap model) {

        carService.deleteCar(car);

        model.addAttribute("success", "Car " + car.getLicensePlate() + " deleted successfully");
        return "success";
    }
}
