package com.carrentalspring.service;

import com.carrentalspring.model.User;

import java.util.List;

public interface UserService {


    void saveUser(User user);

    void deleteUser(User user);

    List<User> getUsers();

    User getUser(int id);

    User getUserByUsername(String username, String password);
}
