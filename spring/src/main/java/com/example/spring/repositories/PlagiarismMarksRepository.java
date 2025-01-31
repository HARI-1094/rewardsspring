package com.example.spring.repositories;

import com.example.spring.models.PlagiarismMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlagiarismMarksRepository extends JpaRepository<PlagiarismMarks, Integer> {
    PlagiarismMarks findByPid(Integer pid);
}
