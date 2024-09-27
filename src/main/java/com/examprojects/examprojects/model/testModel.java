package com.examprojects.examprojects.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tests")
public class testModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String course;
    private Date testDate;
    private int duration;
    private boolean allowFeedback;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private lecturerModel lecturer; // Ensure this is correctly set up

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isAllowFeedback() {
        return allowFeedback;
    }

    public void setAllowFeedback(boolean allowFeedback) {
        this.allowFeedback = allowFeedback;
    }

    public lecturerModel getLecturer() {
        return lecturer;
    }

    public void setLecturer(lecturerModel lecturer) {
        this.lecturer = lecturer;
    }
}
