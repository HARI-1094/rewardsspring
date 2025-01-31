package com.example.spring.controllers;

import com.example.spring.models.Admin;
import com.example.spring.models.Reviewer;
import com.example.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/admin")
    public String adminLogin(@RequestParam String username, @RequestParam String password) {
        Admin admin = userService.findAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return "Admin dashboard";  // Return a success message or dashboard data
        } else {
            return "Invalid admin credentials";
        }
    }

    @PostMapping("/reviewer")
    public String reviewerLogin(@RequestParam String username, @RequestParam String password) {
        Reviewer reviewer = userService.findReviewerByUsername(username);
        if (reviewer != null && reviewer.getPassword().equals(password)) {
            return "Reviewer dashboard";  // Return a success message or dashboard data
        } else {
            return "Invalid reviewer credentials";
        }
    }
}
