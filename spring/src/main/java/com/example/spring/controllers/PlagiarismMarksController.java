package com.example.spring.controllers;

import com.example.spring.models.PlagiarismMarks;
import com.example.spring.services.PlagiarismMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plagiarism-marks")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
public class PlagiarismMarksController {

    @Autowired
    private PlagiarismMarksService plagiarismMarksService;

    @GetMapping("/{pid}")
    public PlagiarismMarks getPlagiarismMarks(@PathVariable Integer pid) {
        PlagiarismMarks plagiarismMarks = plagiarismMarksService.getPlagiarismMarksByPid(pid);
        if (plagiarismMarks == null) {
            throw new RuntimeException("Plagiarism marks not found for PID: " + pid);
        }
        return plagiarismMarks;
    }
}
