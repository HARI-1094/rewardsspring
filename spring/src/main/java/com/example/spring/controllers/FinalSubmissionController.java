package com.example.spring.controllers;

import com.example.spring.models.FinalSubmission;
import com.example.spring.repositories.FinalSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/final_submissions")
@CrossOrigin(origins = "http://localhost:3000")
public class FinalSubmissionController {

    @Autowired
    private FinalSubmissionRepository repository;

    // Retrieve project details by PID
    @GetMapping("/{pid}")
    public FinalSubmission getSubmissionByPid(@PathVariable String pid) {
        Optional<FinalSubmission> submission = repository.findById(pid);
        if (submission.isPresent()) {
            return submission.get();
        } else {
            throw new RuntimeException("Project not found for PID: " + pid);
        }
    }

    // Save or update marks for a project
    @PostMapping
    public FinalSubmission saveSubmission(@RequestBody FinalSubmission submission) {
        Optional<FinalSubmission> existingSubmission = repository.findById(submission.getPid());
        if (existingSubmission.isPresent()) {
            FinalSubmission updatedSubmission = existingSubmission.get();
            updatedSubmission.setMarks(submission.getMarks());
            return repository.save(updatedSubmission);
        } else {
            throw new RuntimeException("Project not found for PID: " + submission.getPid());
        }
    }
}

