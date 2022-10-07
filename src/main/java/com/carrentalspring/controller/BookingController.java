package com.carrentalspring.controller;

import com.carrentalspring.model.Booking;

import com.carrentalspring.service.BookingService;
import com.carrentalspring.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {



    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {

        this.bookingService = bookingService;
    }


    @GetMapping("/list")
    public String listBookings(ModelMap model) {

        List<Booking> bookings = bookingService.getBookings();
        model.addAttribute("bookings", bookings);
        return "allBookings";
    }

    @GetMapping( "/new")
    public String newBooking(ModelMap model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "bookingForm";
    }

    @PostMapping("/new")
    public String saveBooking(Booking booking,
                          ModelMap model) {

        bookingService.saveBooking(booking);

        model.addAttribute("success", "Booking " + booking.getId() + " registered successfully");
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
