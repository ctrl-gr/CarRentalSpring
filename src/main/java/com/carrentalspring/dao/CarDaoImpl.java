package com.carrentalspring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import com.carrentalspring.model.Car;

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
/*
    public List<Car> getAvailableCars(Date startDate, Date endDate) {
            Criteria criteria = createEntityCriteria();
            Criterion start = Restrictions.le("startDate", endDate);
            Criterion end = Restrictions.ge("endDate", startDate);

            criteria.add(Restrictions.and(start, end));


            List<Booking> bookings = criteria.list();
            List<Integer> bookedCars = new ArrayList<>();
            for (Booking booking : bookings) {
                if (booking.getCar() != null && !bookedCars.contains(booking.getCar().getId())) {
                    bookedCars.add(booking.getCar().getId());
                }
            }

            Criteria criteriaCars = createEntityCriteria();
            if (bookedCars.size() > 0) {
                Criterion notInAnyCars = Restrictions.not(Restrictions.in("id", bookedCars));
                criteriaCars.add(notInAnyCars);
            }

            List<Car> availableCars = criteriaCars.list();

            return availableCars;
        }
    */
}

