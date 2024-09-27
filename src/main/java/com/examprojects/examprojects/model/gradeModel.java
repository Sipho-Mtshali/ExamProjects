package com.examprojects.examprojects.model;
import jakarta.persistence.*;

@Entity
@Table(name = "grades")
public class gradeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private testModel  test;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private studentModel student;

    private double score;

    // Getters and Setters
}