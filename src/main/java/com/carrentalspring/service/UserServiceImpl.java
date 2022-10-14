package com.carrentalspring.service;

import java.util.List;

import com.carrentalspring.dao.UserDao;
import com.carrentalspring.dao.UserDaoImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carrentalspring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
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

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}