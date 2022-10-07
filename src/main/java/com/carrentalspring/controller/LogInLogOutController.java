package com.carrentalspring.controller;

import com.carrentalspring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carrentalspring.service.UserService;

@Controller
@RequestMapping("/log")
public class LogInLogOutController {
    private final UserService userService;

    public LogInLogOutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getLogin")
    public String showLogin(Model model) {
        model.addAttribute("msg", "Please enter your login details");
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String checkLogin(@ModelAttribute("user") User user, Model model) {


        if (user.getUsername().equals("admin")) {
            if (userService.validateUserAdmin(user)) {
                model.addAttribute("adminOk", "true");
                model.addAttribute("msg", "Hi " + user.getUsername() + ". Here are your admin actions");
                return "homepage";
            }
        } else if (userService.validateUser(user)) {
            model.addAttribute("userOk", "true");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("msg", "Hi " + user.getUsername() + ".");
            return "homepage";
        } else {
            model.addAttribute("msg", "Wrong username or password. Please, try to log in again");
            return "login";
        }
        model.addAttribute("msg", "Please, log in");
        return "login";
    }

}
