package com.example.spring.repositories;

import com.example.spring.models.TeamCommunicationMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamCommunicationMarksRepository extends JpaRepository<TeamCommunicationMarks, Long> {
}