package com.carrentalspring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.carrentalspring.model.User;


@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserById(int id) {
       Session currentSession = sessionFactory.getCurrentSession();
       User theUser = currentSession.get(User.class, id);
       return theUser;
    }
    public void saveUser(User user) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }


    public void deleteUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < User > cq = cb.createQuery(User.class);
        Root < User > root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
}