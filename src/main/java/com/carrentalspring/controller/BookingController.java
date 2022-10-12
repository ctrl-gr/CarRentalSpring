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
    public String listBookings(@RequestParam("userId")int userId, Model model) {

        List<Booking> bookings = bookingService.getBookings();
        model.addAttribute("userId", userId);
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

    @GetMapping( "/getNew")
    public String newBooking(@RequestParam("userId")int userId, ModelMap model) {

        Booking booking = new Booking();
        booking.setUser(userService.getUser(userId));
        model.addAttribute("adminOk");
        model.addAttribute("userOk");
        model.addAttribute("userId", userId);

        model.addAttribute("booking", booking);
        return "bookingForm";
    }

    @PostMapping("/new")
    public String saveBooking(@ModelAttribute("booking")Booking booking, @RequestParam("carId")int carId, @RequestParam("userId")int userId,
                          ModelMap model) {

        Car car = carService.getCarById(carId);
        User user = userService.getUser(userId);
        boolean userOk = true;
        booking.setUser(user);
        booking.setCar(car);
        bookingService.saveBooking(booking);

        model.addAttribute("success", "Booking " + booking.getId() + " registered successfully");
        model.addAttribute("userId", userId);
        model.addAttribute("userOk", userOk);
        return "success";
    }

    @PostMapping("/edit")
    public String updateBooking(Booking booking, ModelMap model) {
        bookingService.updateBooking(booking);

        model.addAttribute("success", "Booking " + booking.getId() + " updated successfully");
        return "success";

    }
//TODO can not show all bookings with updates
    @PostMapping("/approve")
    public String approveBooking(@RequestParam("bookingId")int bookingId, @RequestParam("userId")int userId, Model model) {
        List<Booking> bookings = bookingService.getBookings();
        Booking booking = bookingService.getBookingById(bookingId);
        booking.setIsApproved(true);
        bookingService.updateBooking(booking);
        model.addAttribute("userId", userId);
        model.addAttribute("bookings", bookings);

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
