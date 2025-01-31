package com.example.spring.controllers;

import com.example.spring.models.InitialSubmission;
import com.example.spring.repositories.InitialSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/submissions")
@CrossOrigin(origins = "http://localhost:3000")
public class InitialSubmissionController {

    @Autowired
    private InitialSubmissionRepository repository;

    // Retrieve project details by PID
    @GetMapping("/{pid}")
    public InitialSubmission getSubmissionByPid(@PathVariable String pid) {
        Optional<InitialSubmission> submission = repository.findById(pid);
        if (submission.isPresent()) {
            return submission.get();
        } else {
            throw new RuntimeException("Project not found for PID: " + pid);
        }
    }

    // Save or update marks for a project
    @PostMapping
    public InitialSubmission saveSubmission(@RequestBody InitialSubmission submission) {
        Optional<InitialSubmission> existingSubmission = repository.findById(submission.getPid());
        if (existingSubmission.isPresent()) {
            InitialSubmission updatedSubmission = existingSubmission.get();
            updatedSubmission.setMarks(submission.getMarks());
            return repository.save(updatedSubmission);
        } else {
            throw new RuntimeException("Project not found for PID: " + submission.getPid());
        }
    }
}
