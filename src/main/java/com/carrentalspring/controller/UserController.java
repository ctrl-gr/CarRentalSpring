package com.carrentalspring.controller;

import com.carrentalspring.model.User;
import com.carrentalspring.service.UserService;
import java.util.List;

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
    public String listUsers(@RequestParam("userId")int userId, Model model) {

        List<User> users = userService.getUsers();
        model.addAttribute("userId", userId);
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping( "/getNew" )
    public String newUser(@RequestParam("userId")int userId, Model model) {
        User user = new User();
        model.addAttribute("userId", userId);
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
        user = userService.getUser(id);
        model.addAttribute("user", user);

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
