package com.carrentalspring.controller;

import com.carrentalspring.model.Booking;
import com.carrentalspring.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @RequestMapping(value = {  "/list" }, method = RequestMethod.GET)
    public String listBookings(ModelMap model) {

        List<Booking> bookings = bookingService.getBookings();
        model.addAttribute("bookings", bookings);
        return "allBookings";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newBooking(ModelMap model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "bookingForm";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveBooking(Booking booking,
                          ModelMap model) {

        bookingService.saveBooking(booking);

        model.addAttribute("success", "Booking " + booking.getId() + " registered successfully");
        return "success";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public String updateBooking(Booking booking, ModelMap model) {
        bookingService.updateBooking(booking);

        model.addAttribute("success", "Booking " + booking.getId() + " updated successfully");
        return "success";

    }

    @RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
    public String deleteBooking(Booking booking,
                            ModelMap model) {

        bookingService.deleteBooking(booking);

        model.addAttribute("success", "Booking" + booking.getId() + " deleted successfully");
        return "success";
    }
}
