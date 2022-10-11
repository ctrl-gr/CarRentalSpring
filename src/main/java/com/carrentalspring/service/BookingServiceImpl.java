package com.carrentalspring.service;

import java.util.List;

import com.carrentalspring.dao.BookingDao;
import com.carrentalspring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carrentalspring.model.Booking;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingDao bookingDao;

    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    @Transactional
    public void saveBooking(Booking booking) {
        bookingDao.saveBooking(booking);
    }

    @Override
    @Transactional
    public void updateBooking(Booking booking) {
        Booking entity = bookingDao.getBookingById(booking.getId());
        if (entity != null) {
            booking.setUser(booking.getUser());
            booking.setCar(booking.getCar());
            booking.setStartDate(booking.getStartDate());
            booking.setEndDate(booking.getEndDate());
            booking.setIsApproved(booking.getIsApproved());
        }

        bookingDao.saveBooking(entity);
    }

    @Override
    @Transactional
    public void deleteBooking(Booking booking) {
        bookingDao.deleteBooking(booking);
    }

    @Override
    @Transactional
    public Booking getBookingById(int id) {
        return bookingDao.getBookingById(id);
    }

    @Override
    @Transactional
    public List<Booking> getBookingsByUser(User user) {
        return bookingDao.getBookingsByUser(user);
    }

    @Override
    @Transactional
    public List<Booking> getBookings() {
        return bookingDao.getBookings();
    }
}