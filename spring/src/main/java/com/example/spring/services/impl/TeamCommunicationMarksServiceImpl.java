package com.example.spring.services.impl;

import com.example.spring.models.TeamCommunicationMarks;
import com.example.spring.repositories.TeamCommunicationMarksRepository;
import com.example.spring.services.TeamCommunicationMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamCommunicationMarksServiceImpl implements TeamCommunicationMarksService {

    @Autowired
    private TeamCommunicationMarksRepository repository;

    @Override
    public TeamCommunicationMarks saveTeamCommunicationMarks(TeamCommunicationMarks marks) {
        return repository.save(marks);
    }

    @Override
    public long countAllotedMarks() {
        return repository.count(); // Counts the total number of rows in the TeamCommunicationMarks table
    }
}
