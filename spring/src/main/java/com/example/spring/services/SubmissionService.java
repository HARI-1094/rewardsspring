package com.example.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countFinalSubmissionPIDs() {
        String query = "SELECT COUNT(DISTINCT pid) FROM final_submission WHERE marks IS NOT NULL";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public int countInitialSubmissionPIDs() {
        String query = "SELECT COUNT(DISTINCT pid) FROM initial_submission WHERE marks IS NOT NULL";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }
}
