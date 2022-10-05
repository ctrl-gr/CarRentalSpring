package com.carrentalspring.service;

import java.util.List;

import com.carrentalspring.model.Booking;

public interface BookingService {
    void saveBooking(Booking booking);
    void updateBooking(Booking booking);
    void deleteBooking(Booking booking);
    Booking getBookingById(int id);
    List<Booking> getBookings();
}
