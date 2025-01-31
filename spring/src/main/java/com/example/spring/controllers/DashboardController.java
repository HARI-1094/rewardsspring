package com.example.spring.controllers;

import com.example.spring.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

    @Autowired
    private SubmissionService submissionService;

    @GetMapping("/counts")
    public Map<String, Integer> getCounts() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("finalSubmissionCount", submissionService.countFinalSubmissionPIDs());
        counts.put("initialSubmissionCount", submissionService.countInitialSubmissionPIDs());
        return counts;
    }
}

