package com.example.spring.repositories;

import com.example.spring.models.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {

    // Spring Data JPA will automatically implement this query based on method name
    Reviewer findByUsername(String username);
}

