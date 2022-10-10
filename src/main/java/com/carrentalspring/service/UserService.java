package com.carrentalspring.service;

import java.util.List;

import com.carrentalspring.model.User;

public interface UserService {


    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);

    boolean validateUser(User user);
    boolean validateUserAdmin(User user);

    List<User> getUsers();
    User getUser(int id);

    User getUserByUsername(String username, String password);
}
