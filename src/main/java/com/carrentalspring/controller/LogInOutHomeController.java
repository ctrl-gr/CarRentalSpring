package com.carrentalspring.controller;

import com.carrentalspring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.carrentalspring.service.UserService;

@Controller
@RequestMapping("/log")
public class LogInOutHomeController {
    private final UserService userService;

    public LogInOutHomeController(UserService userService) {
        this.userService = userService;
    }
//TODO show error message when wrong credentials.
    @GetMapping("/getLogin")
    public String showLogin(Model model) {
        model.addAttribute("msg", "Please enter your login details");
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String checkLogin(@ModelAttribute("user") User user, Model model) {

        User userFound = userService.getUserByUsername(user.getUsername(), user.getPassword());
        if (userFound == null) {
            model.addAttribute("msg", "Wrong username or password. Please, try to log in again");
            return "login";

        }

        if (userFound.isAdmin()) {
            model.addAttribute("adminOk", "true");
            model.addAttribute("user", userFound);
            model.addAttribute("userId", userFound.getId());
            model.addAttribute("msg", "Hi " + user.getUsername() + ". Here are your admin actions. Make them through the navbar.");
            return "homepage";
        } else {
            model.addAttribute("userOk", "true");
            model.addAttribute("user", userFound);
            model.addAttribute("userId", userFound.getId());
            model.addAttribute("msg", "Hi " + user.getUsername() + ".");
            return "homepage";
        }
    }

    @GetMapping("/homepage")
    public String getHomepage(@RequestParam("userId")int userId, Model model) {

        String username = userService.getUser(userId).getUsername();
        model.addAttribute("userOk", true);
        model.addAttribute("msg", "Hi " + username + ".");
        model.addAttribute("userId", userId);
        return "homepage";
    }

}
