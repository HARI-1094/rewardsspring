package com.example.spring.services;

import com.example.spring.models.Admin;
import com.example.spring.models.Reviewer;
import com.example.spring.repositories.AdminRepository;
import com.example.spring.repositories.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ReviewerRepository reviewerRepository;

    // Find Admin by username
    public Admin findAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    // Find Reviewer by username
    public Reviewer findReviewerByUsername(String username) {
        return reviewerRepository.findByUsername(username);
    }
}
