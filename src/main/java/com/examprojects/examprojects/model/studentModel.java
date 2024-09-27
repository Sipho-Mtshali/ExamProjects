package com.examprojects.examprojects.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class studentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "student")
    private List<gradeModel> grades;

    // Getters and Setters
}