package com.carrentalspring.dao;


import com.carrentalspring.model.Booking;
import com.carrentalspring.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car getCarById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Car theCar = currentSession.get(Car.class, id);
        return theCar;
    }

    @Override
    public void saveCar(Car car) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(car);
    }


    @Override
    public void deleteCar(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(car);
    }

    @Override
    public List<Car> getCars() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Car> cq = cb.createQuery(Car.class);
        Root<Car> root = cq.from(Car.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Car> getAvailableCars(Date startDate, Date endDate) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Booking> queryBooking = builder.createQuery(Booking.class);
        Root<Booking> root = queryBooking.from(Booking.class);

        List<Predicate> fromStartToEnd = new ArrayList<Predicate>();
        Predicate onStart = builder.lessThanOrEqualTo(root.get("startDate"), endDate);
        Predicate onEnd = builder.greaterThanOrEqualTo(root.get("endDate"), startDate);
        fromStartToEnd.add(onStart);
        fromStartToEnd.add(onEnd);
        queryBooking.select(root).where(builder.and(fromStartToEnd.toArray(new Predicate[]{})));

        List<Booking> bookings = session.createQuery(queryBooking).getResultList();
        List<Integer> bookedCars = new ArrayList<>();

        for (Booking booking : bookings) {
            if (booking.getCar() != null && !bookedCars.contains(booking.getCar().getId())) {
                bookedCars.add(booking.getCar().getId());
            }
        }

        CriteriaQuery<Car> queryCars = builder.createQuery(Car.class);
        Root<Car> rootCar = queryCars.from(Car.class);

        if (bookedCars.size() > 0) {

            Predicate notInAnyBooking = builder.not(builder.in(rootCar.get("id")).value(bookedCars));


            queryCars.select(rootCar).where(notInAnyBooking);
        } else {
            queryCars.select(rootCar);
        }

        return session.createQuery(queryCars).getResultList();


    }

}
