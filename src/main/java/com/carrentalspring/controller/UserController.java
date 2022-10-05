package com.carrentalspring.controller;

import com.carrentalspring.model.User;
import com.carrentalspring.service.UserService;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping( "/new" )
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userForm";
    }

    @PostMapping("/new")
    public String saveUser(User user,
                           Model model) {

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getUsername() + " registered successfully");
        return "success";
    }

    @GetMapping("/edit")
    public String updateUser(User user, Model model, int id) {
        User theUser = userService.getUser(id);
        model.addAttribute("user", theUser);

        return "userForm";
    }

    @PostMapping("/edit")
    public String updateUser(User user, Model model) {
        userService.updateUser(user);
        model.addAttribute("success", "User " + user.getUsername() + " updated successfully");
        return "success";
    }

    @GetMapping("/delete")
    public String deleteUser(User user, Model model) {

        userService.deleteUser(user);

        model.addAttribute("success", "User " + user.getUsername() + " deleted successfully");
        return "success";
    }
}
