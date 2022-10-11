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
        model.addAttribute("userId", userId);
        return "userBookings";
    }

    @GetMapping("/homepage")
    public String getHomepage(Model model, @RequestParam("userId")int userId) {

        String username = userService.getUser(userId).getUsername();
        model.addAttribute("userOk", true);
        model.addAttribute("msg", "Hi " + username + ".");
        model.addAttribute("userId", userId);
        return "homepage";
    }
//TODO can not pass userId between servlets
    @GetMapping( "/getNew")
    public String newBooking(@RequestParam("userId")int userId, ModelMap model) {

        Booking booking = new Booking();
        booking.setUser(userService.getUser(userId));
        model.addAttribute("userId", userId);
        model.addAttribute("booking", booking);
        return "bookingForm";
    }

    @PostMapping("/new")
    public String saveBooking(@ModelAttribute("booking")Booking booking, @RequestParam("carId")int carId, @RequestParam("userId")int userId,
                          ModelMap model) {

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
//TODO can not get car and user from allBookings
    @PostMapping("/approve")
    public String approveBooking(@RequestParam("bookingId")int bookingId) {

        Booking bookingToUpdate = bookingService.getBookingById(bookingId);
        bookingToUpdate.setIsApproved(true);
        bookingService.updateBooking(bookingToUpdate);

        return "allBookings";
    }

    @GetMapping("/delete")
    public String deleteBooking(Booking booking,
                            ModelMap model) {

        bookingService.deleteBooking(booking);

        model.addAttribute("success", "Booking" + booking.getId() + " deleted successfully");
        return "success";
    }


}
