package com.carrentalspring.dao;

import java.util.List;

import com.carrentalspring.model.Booking;
import com.carrentalspring.model.User;

public interface BookingDao {
    void saveBooking(Booking booking);
    void deleteBooking(Booking booking);
    Booking getBookingById(int id);
    List<Booking> getBookingsByUser(User user);
    List<Booking> getBookings();
}