package com.carrentalspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {


    @GetMapping("/form")
    public String getLogin(Model model) {
        return "login";
    }

    @GetMapping("/homepage")
    public String getHomepage() {
        return "homepage";
    }
}

//TODO implement log out