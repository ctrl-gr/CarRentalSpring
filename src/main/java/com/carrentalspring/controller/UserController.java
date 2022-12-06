package com.carrentalspring.controller;

import com.carrentalspring.model.User;
import com.carrentalspring.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
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

    @GetMapping("/newFromUser")
    public String newUserFromUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "userFormUser";
    }

    @PostMapping("/save")
    public String saveUser(User user,
                           Model model) {

        userService.saveUser(user);

        return listUsers(model);
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult br,
                               Model model) {
        if (br.hasErrors()) {
            return "userFormUser";
        } else {
            userService.saveUser(user);
            model.addAttribute("success", "User " + user.getUsername() + " registered successfully. Please, log in with your new credentials.");
            return "success";
        }
    }


    @GetMapping("/getEdit")
    public String updateUser(@RequestParam("userId") int userId, Model model) {

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
    public String deleteUser(@RequestParam("userId") int userId, Model model) {

        User user = userService.getUser(userId);
        userService.deleteUser(user);
        model.addAttribute("userId", userId);

        return listUsers(model);
    }
}
