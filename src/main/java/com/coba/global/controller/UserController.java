package com.coba.global.controller;

import com.coba.global.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model, @RequestParam(defaultValue = "")String name) {
        model.addAttribute("user", userService.findByName(name));

        return "views/list";
    }
}
