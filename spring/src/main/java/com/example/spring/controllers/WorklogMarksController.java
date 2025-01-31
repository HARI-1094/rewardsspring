package com.example.spring.controllers;

import com.example.spring.models.WorklogMarks;
import com.example.spring.services.WorklogMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/worklog-marks")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
public class WorklogMarksController {

    @Autowired
    private WorklogMarksService worklogMarksService;

    @GetMapping("/{pid}")
    public WorklogMarks getWorklogMarks(@PathVariable Integer pid) {
        WorklogMarks worklogMarks = worklogMarksService.getWorklogMarksByPid(pid);
        if (worklogMarks == null) {
            throw new RuntimeException("Worklog marks not found for PID: " + pid);
        }
        return worklogMarks;
    }
}
