package com.coba.global.controller;

import com.coba.global.entities.User;
import com.coba.global.services.TaskService;
import com.coba.global.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/profile")
    public String profilePage(Model model, Principal principal){
        String email = principal.getName();
        User user = userService.findOne(email);

        model.addAttribute("tasks", taskService.findUserTask(user));

        return "views/profile";
    }

}
