package com.coba.global.controller;

import com.coba.global.entities.Task;
import com.coba.global.services.TaskService;
import com.coba.global.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession session) {

        session.setAttribute("email", email);
        model.addAttribute("task", new Task());
        return "views/taskform";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()){
            return "views/taskform";
        }
        String email = (String) session.getAttribute("email");
        taskService.addTask(task, userService.findOne(email));

        return "redirect:/users";
    }
}
