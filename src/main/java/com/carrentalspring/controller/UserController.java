package com.carrentalspring.controller;

import com.carrentalspring.model.User;
import com.carrentalspring.security.CustomUserDetails;
import com.carrentalspring.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(Model model) {

        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "userForm";


    }

    @PostMapping("/save")
    public String saveUser(User user,
                           Model model) {

        userService.saveUser(user);

        return listUsers(model);
    }

    @PostMapping("/register")
    public String registerUser(User user,
                           Model model) {

        userService.saveUser(user);
        model.addAttribute("success", "User " + user.getUsername() + " registered successfully. Please, log in with your new credentials.");
        return "success";
    }


    @GetMapping("/getEdit")
    public String updateUser(@RequestParam("userId")int userId, Model model) {

        User user = userService.getUser(userId);
        model.addAttribute("user", user);

        return "editUserForm";
    }

    @PostMapping("/edit")
    public String updateUser(User user, Model model) {

        int userId = user.getId();
        userService.saveUser(user);
        model.addAttribute("userId", userId);
        model.addAttribute("success", "User " + user.getUsername() + " updated successfully");

        return "success";
    }


    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId")int userId, Model model) {

        User user = userService.getUser(userId);
        userService.deleteUser(user);
        model.addAttribute("userId", userId);

        return listUsers(model);
    }
}
