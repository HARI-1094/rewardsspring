package com.example.spring.services;

import com.example.spring.models.WorklogMarks;
import com.example.spring.repositories.WorklogMarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorklogMarksService {

    @Autowired
    private WorklogMarksRepository worklogMarksRepository;

    public WorklogMarks getWorklogMarksByPid(Integer pid) {
        return worklogMarksRepository.findByPid(pid);
    }
}
