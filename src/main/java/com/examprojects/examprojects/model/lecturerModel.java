package com.examprojects.examprojects.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "lecturers")
public class lecturerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "lecturer")
    private List<testModel> tests;

    // Getter for id
    public Long getId()
    {
        return id;
    }

    // Setter for id
    public void setId(Long id)
    {
        this.id = id;
    }

    // Getter for name
    public String getName()
    {
        return name;
    }

    // Setter for name
    public void setName(String name)
    {
        this.name = name;
    }

    // Getter for email
    public String getEmail()
    {
        return email;
    }

    // Setter for email
    public void setEmail(String email)
    {
        this.email = email;
    }

    // Getter for tests
    public List<testModel> getTests()
    {
        return tests;
    }

    // Setter for tests
    public void setTests(List<testModel> tests)
    {
        this.tests = tests;
    }
}
