package com.example.spring.repositories;

import com.example.spring.models.InitialSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitialSubmissionRepository extends JpaRepository<InitialSubmission, String> {
}

