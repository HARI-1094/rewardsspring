package com.example.spring.services;

import com.example.spring.models.TeamCommunicationMarks;

public interface TeamCommunicationMarksService {
    TeamCommunicationMarks saveTeamCommunicationMarks(TeamCommunicationMarks marks);
    long countAllotedMarks(); // Add this method to count allotted marks
}
