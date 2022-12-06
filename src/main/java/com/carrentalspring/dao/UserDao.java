package com.carrentalspring.dao;

import com.carrentalspring.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(int id);

    void saveUser(User user);

    void deleteUser(User user);

    boolean validateUser(User user);

    boolean validateUserAdmin(User user);

    List<User> getUsers();

    User getUserByUsername(String username, String password);

    User getUserByUsername(String username);
}
