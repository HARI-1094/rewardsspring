package com.example.spring.controllers;

import com.example.spring.models.Marks;
import com.example.spring.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from the frontend (localhost:3000)
public class MarksController {

    @Autowired
    private MarksService marksService;

    @PostMapping
    public Marks submitMarks(@RequestBody Marks marks) {
        int total = marks.getIdea() + marks.getConciseness() + marks.getClarity() +
                marks.getNovelty() + marks.getExecution() + marks.getCompleteness() +
                marks.getCoordination() + marks.getWorkSplitUp();
        marks.setTotalMarks(total);
        return marksService.saveMarks(marks);
    }

    @GetMapping("/count")
    public long countAllotedReviewerMarks() {
        return marksService.countAllotedMarks();
    }
}
