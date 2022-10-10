package com.carrentalspring.dao;

import java.util.List;

import javax.persistence.NoResultException;
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

    @Override
    public void saveUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }
    @Override
    public boolean validateUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        try {
            Query query = session.createQuery("from User where username =:username and password =:password", User.class);
            query.setParameter("username", user.getUsername());
            query.setParameter("password", user.getPassword());
            user = (User) query.getSingleResult();

            if (user != null) {
                return true;
            }
        }   catch(NoResultException e){
                e.printStackTrace();

            }
        return false;
        }

        @Override
        public boolean validateUserAdmin(User user) {
            Session session = sessionFactory.getCurrentSession();

            try {
                Query query = session.createQuery("from User where username =:username and password =:password", User.class);
                query.setParameter("username", user.getUsername());
                query.setParameter("password", user.getPassword());
                user = (User) query.getSingleResult();

                if (user != null && user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
                    return true;
                }
            }   catch(NoResultException e){
                e.printStackTrace();

            }
            return false;
        }



    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < User > cq = cb.createQuery(User.class);
        Root < User > root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public User getUserByUsername(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username =:username and password =:password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = (User) query.getSingleResult();

        return user;
    }
}