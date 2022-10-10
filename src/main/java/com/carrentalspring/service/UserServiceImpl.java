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
    public void saveUser(User user) {

        userDao.saveUser(user);
    }

    @Override

    public void updateUser(User user) {
        User entity = userDao.getUserById(user.getId());
        if (entity != null) {
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setBirthDate(user.getBirthDate());
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
        }
        userDao.saveUser(entity);
    }

    @Override


    public User getUser(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username, String password) {
        return userDao.getUserByUsername(username, password);
    }

    @Override

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public boolean validateUser(User user) {
        return userDao.validateUser(user);
    }

    @Override
    public boolean validateUserAdmin(User user) {
        return userDao.validateUserAdmin(user);
    }


    @Override

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}