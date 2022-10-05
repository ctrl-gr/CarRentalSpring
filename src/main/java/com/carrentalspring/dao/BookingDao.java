package com.carrentalspring.dao;

import java.util.List;

import com.carrentalspring.model.Booking;

public interface BookingDao {
    void saveBooking(Booking booking);
    void deleteBooking(Booking booking);
    public Booking getBookingById(int id);
    public List<Booking> getBookings();
}