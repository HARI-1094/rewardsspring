package com.example.spring.services;

import com.example.spring.models.PlagiarismMarks;
import com.example.spring.repositories.PlagiarismMarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlagiarismMarksService {

    @Autowired
    private PlagiarismMarksRepository plagiarismMarksRepository;

    public PlagiarismMarks getPlagiarismMarksByPid(Integer pid) {
        return plagiarismMarksRepository.findByPid(pid);
    }
}