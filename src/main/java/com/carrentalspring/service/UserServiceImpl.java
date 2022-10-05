package com.carrentalspring.service;

import java.util.List;

import com.carrentalspring.dao.UserDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carrentalspring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional

    public void saveUser(User user) {

        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User entity = userDao.getUserById(user.getId());
        if (entity != null) {
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setBirthDate(user.getBirthDate());
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
        }
    }

    @Override
    @Transactional

    public User getUser(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}