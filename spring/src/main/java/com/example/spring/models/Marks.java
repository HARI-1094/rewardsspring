package com.example.spring.models;

import jakarta.persistence.*;

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pid;

    private int idea;
    private int conciseness;
    private int clarity;
    private int novelty;
    private int execution;
    private int completeness;
    private int coordination;
    private int workSplitUp;

    @Column(nullable = false)
    private int totalMarks;

    // Default Constructor
    public Marks() {
    }

    // Parameterized Constructor
    public Marks(String pid, int idea, int conciseness, int clarity, int novelty, int execution,
                 int completeness, int coordination, int workSplitUp) {
        this.pid = pid;
        this.idea = idea;
        this.conciseness = conciseness;
        this.clarity = clarity;
        this.novelty = novelty;
        this.execution = execution;
        this.completeness = completeness;
        this.coordination = coordination;
        this.workSplitUp = workSplitUp;
        this.totalMarks = calculateTotalMarks();
    }

    // Calculate Total Marks
    public int calculateTotalMarks() {
        return idea + conciseness + clarity + novelty + execution + completeness + coordination + workSplitUp;
    }

    // Update Total Marks Automatically
    @PrePersist
    @PreUpdate
    public void updateTotalMarks() {
        this.totalMarks = calculateTotalMarks();
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

    public int getConciseness() {
        return conciseness;
    }

    public void setConciseness(int conciseness) {
        this.conciseness = conciseness;
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

    public int getWorkSplitUp() {
        return workSplitUp;
    }

    public void setWorkSplitUp(int workSplitUp) {
        this.workSplitUp = workSplitUp;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }
}
