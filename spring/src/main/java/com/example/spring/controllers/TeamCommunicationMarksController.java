package com.example.spring.controllers;

import com.example.spring.models.TeamCommunicationMarks;
import com.example.spring.services.TeamCommunicationMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team-communication-marks")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from the frontend (localhost:3000)
public class TeamCommunicationMarksController {

    @Autowired
    private TeamCommunicationMarksService service;

    @PostMapping
    public TeamCommunicationMarks saveMarks(@RequestBody TeamCommunicationMarks marks) {
        return service.saveTeamCommunicationMarks(marks);
    }

    @GetMapping("/count")
    public long countAllotedTeamCommunicationMarks() {
        return service.countAllotedMarks();
    }
}
