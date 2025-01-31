package com.example.spring.repositories;

import com.example.spring.models.WorklogMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorklogMarksRepository extends JpaRepository<WorklogMarks, Integer> {
    WorklogMarks findByPid(Integer pid);
}
