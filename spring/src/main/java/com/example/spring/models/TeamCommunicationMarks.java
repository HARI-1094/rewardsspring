package com.example.spring.models;

import jakarta.persistence.*;

@Entity
public class TeamCommunicationMarks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pid;

    private int idea;
    private int clarity;
    private int novelty;
    private int execution;
    private int completeness;
    private int coordination;

    @Column(nullable = false)
    private int totalCommunicationMarks;

    // Default Constructor
    public TeamCommunicationMarks() {
    }

    // Parameterized Constructor
    public TeamCommunicationMarks(String pid, int idea, int clarity, int novelty, int execution,
                                  int completeness, int coordination) {
        this.pid = pid;
        this.idea = idea;
        this.clarity = clarity;
        this.novelty = novelty;
        this.execution = execution;
        this.completeness = completeness;
        this.coordination = coordination;
        this.totalCommunicationMarks = calculateTotalCommunicationMarks();
    }

    // Calculate Total Communication Marks
    public int calculateTotalCommunicationMarks() {
        return idea + clarity + novelty + execution + completeness + coordination;
    }

    // Update Total Communication Marks Automatically
    @PrePersist
    @PreUpdate
    public void updateTotalCommunicationMarks() {
        this.totalCommunicationMarks = calculateTotalCommunicationMarks();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getIdea() {
        return idea;
    }

    public void setIdea(int idea) {
        this.idea = idea;
    }

    public int getClarity() {
        return clarity;
    }

    public void setClarity(int clarity) {
        this.clarity = clarity;
    }

    public int getNovelty() {
        return novelty;
    }

    public void setNovelty(int novelty) {
        this.novelty = novelty;
    }

    public int getExecution() {
        return execution;
    }

    public void setExecution(int execution) {
        this.execution = execution;
    }

    public int getCompleteness() {
        return completeness;
    }

    public void setCompleteness(int completeness) {
        this.completeness = completeness;
    }

    public int getCoordination() {
        return coordination;
    }

    public void setCoordination(int coordination) {
        this.coordination = coordination;
    }

    public int getTotalCommunicationMarks() {
        return totalCommunicationMarks;
    }

    public void setTotalCommunicationMarks(int totalCommunicationMarks) {
        this.totalCommunicationMarks = totalCommunicationMarks;
    }
}
