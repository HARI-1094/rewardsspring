package com.example.spring.services.impl;

import com.example.spring.models.Marks;
import com.example.spring.repositories.MarksRepository;
import com.example.spring.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public Marks saveMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    @Override
    public long countAllotedMarks() {
        return marksRepository.count(); // Counts the total number of rows in the Marks table
    }
}
