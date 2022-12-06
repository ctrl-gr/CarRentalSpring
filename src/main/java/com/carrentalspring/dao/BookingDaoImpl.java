package com.carrentalspring.dao;

import com.carrentalspring.model.Booking;
import com.carrentalspring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookingDaoImpl implements BookingDao {

    private final SessionFactory sessionFactory;

    public BookingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveBooking(Booking booking) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(booking);

    }

    @Override
    public void deleteBooking(Booking booking) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(booking);
    }

    @Override
    public Booking getBookingById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Booking booking = session.get(Booking.class, id);
        return booking;
    }

    @Override
    public List<Booking> getBookings() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Booking> cq = cb.createQuery(Booking.class);
        Root<Booking> root = cq.from(Booking.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Booking> getBookingsByUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Booking> query = builder.createQuery(Booking.class);
        Root<Booking> root = query.from(Booking.class);
        query.select(root).where(builder.equal(root.get("user"), user));
        Query queryBooking = session.createQuery(query);
        List<Booking> userBookings = queryBooking.getResultList();
        return userBookings;
    }
}