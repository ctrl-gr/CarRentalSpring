package com.carrentalspring.controller;

import com.carrentalspring.model.Booking;
import com.carrentalspring.model.Car;
import com.carrentalspring.model.User;
import com.carrentalspring.security.CustomUserDetails;
import com.carrentalspring.service.BookingService;
import com.carrentalspring.service.CarService;
import com.carrentalspring.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String listBookings(Model model) {

        List<Booking> bookings = bookingService.getBookings();
        model.addAttribute("bookings", bookings);
        return "allBookings";
    }

    @GetMapping("/myBookings")
    public String myBookings(Model model) {

        CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(currentUser.getId());
        List<Booking> myBookings = bookingService.getBookingsByUser(user);
        model.addAttribute("myBookings", myBookings);
        return "userBookings";
    }

    @GetMapping("/getNew")
    public String newBooking(Model model) {

        CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(currentUser.getId());
        Booking booking = new Booking();
        booking.setUser(user);
        model.addAttribute("booking", booking);

        return "bookingForm";
    }

    @PostMapping("/new")
    public String saveBooking(@ModelAttribute("booking") Booking booking, @RequestParam("carId") int carId,
                              Model model) {

        CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(currentUser.getId());
        Car car = carService.getCarById(carId);
        booking.setUser(user);
        booking.setCar(car);
        bookingService.saveBooking(booking);

        model.addAttribute("success", "Booking " + booking.getId() + " registered successfully");

        return "success";
    }

    @PostMapping("/edit")
    public String updateBooking(Booking booking, Model model) {

        bookingService.updateBooking(booking);
        model.addAttribute("success", "Booking " + booking.getId() + " updated successfully");

        return "success";

    }

    @PostMapping("/approve")
    public String approveBooking(@RequestParam("bookingId") int bookingId, Model model) {

        Booking booking = bookingService.getBookingById(bookingId);
        booking.setIsApproved(true);
        bookingService.updateBooking(booking);

        return listBookings(model);
    }

    @GetMapping("/delete")
    public String deleteBooking(@RequestParam("bookingId") int bookingId,
                                Model model) {
        Booking booking = bookingService.getBookingById(bookingId);
        bookingService.deleteBooking(booking);

        return listBookings(model);
    }

}
