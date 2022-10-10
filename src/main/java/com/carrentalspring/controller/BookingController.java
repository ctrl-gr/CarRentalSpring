package com.carrentalspring.controller;

import com.carrentalspring.model.Booking;

import com.carrentalspring.model.Car;
import com.carrentalspring.model.User;
import com.carrentalspring.service.BookingService;
import com.carrentalspring.service.CarService;
import com.carrentalspring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO check myBookings and saveBooking
@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;
    private final CarService carService;
    private final UserService userService;

    public BookingController(BookingService bookingService, CarService carService, UserService userService) {

        this.bookingService = bookingService;
        this.carService = carService;
        this.userService = userService;
    }


    @GetMapping("/list")
    public String listBookings(ModelMap model) {

        List<Booking> bookings = bookingService.getBookings();
        model.addAttribute("bookings", bookings);
        return "allBookings";
    }

    @GetMapping("/myBookings")

    public String myBookings(Model model, @RequestParam("userId")int userId) {
        User user = userService.getUser(userId);
        List<Booking> myBookings = bookingService.getBookingsByUser(user);
        model.addAttribute("myBookings", myBookings);
        return "userBookings";
    }

    @GetMapping( "/new")
    public String newBooking(@RequestParam("userId")int userId, ModelMap model) {

        Booking booking = new Booking();
        model.addAttribute("userId", userId);
        model.addAttribute("booking", booking);
        return "bookingForm";
    }

    @PostMapping("/new")
    public String saveBooking(@ModelAttribute("booking")Booking booking, @RequestParam("carId")int carId, @RequestParam("userId")int userId,
                          ModelMap model) {
//this is just saving into DB booking_id, anything else. I'm fixing it
        Car car = carService.getCarById(carId);
        User user = userService.getUser(userId);
        booking.setUser(user);
        booking.setCar(car);
        bookingService.saveBooking(booking);

        model.addAttribute("success", "Booking " + booking.getId() + " registered successfully");
        model.addAttribute("userId", userId);
        return "success";
    }

    @PostMapping("/edit")
    public String updateBooking(Booking booking, ModelMap model) {
        bookingService.updateBooking(booking);

        model.addAttribute("success", "Booking " + booking.getId() + " updated successfully");
        return "success";

    }

    @GetMapping("/delete")
    public String deleteBooking(Booking booking,
                            ModelMap model) {

        bookingService.deleteBooking(booking);

        model.addAttribute("success", "Booking" + booking.getId() + " deleted successfully");
        return "success";
    }


}
