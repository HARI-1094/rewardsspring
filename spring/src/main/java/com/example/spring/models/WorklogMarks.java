package com.example.spring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "worklog_marks")
public class WorklogMarks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private Integer marks;

    // Getters and Setters
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}
