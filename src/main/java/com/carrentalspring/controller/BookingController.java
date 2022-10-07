package com.carrentalspring.controller;

import com.carrentalspring.model.Booking;

import com.carrentalspring.model.User;
import com.carrentalspring.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//TODO check myBookings and saveBooking
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

    @GetMapping("/myBookings")
    /*this is not working correctly. Getting hibernate exception. In my opinion that's because the query is trying to get
    data from the DB but is getting back error because in my booking table I just have the booking_id. Null value for
    user_id, car_id, startDate, endDate
    */
    public String myBookings(Model model, User user) {
        List<Booking> myBookings = bookingService.getBookingsByUser(user);
        model.addAttribute("myBookings", myBookings);
        return "userBookings";
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
//this is just saving into DB booking_id, anything else. I'm fixing it
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
