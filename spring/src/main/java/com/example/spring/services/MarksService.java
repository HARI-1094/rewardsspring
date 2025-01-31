package com.example.spring.services;

import com.example.spring.models.Marks;

public interface MarksService {
    Marks saveMarks(Marks marks);
    long countAllotedMarks(); // Add this method to count allotted marks
}
