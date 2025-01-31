package com.example.spring.repositories;

import com.example.spring.models.FinalSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalSubmissionRepository extends JpaRepository<FinalSubmission, String> {
}
