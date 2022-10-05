package com.carrentalspring.dao;

import java.util.List;

import com.carrentalspring.model.User;

public interface UserDao {
    User getUserById(int id);
    void saveUser(User user);
    void deleteUser(User user);
    List<User> getUsers();
}
