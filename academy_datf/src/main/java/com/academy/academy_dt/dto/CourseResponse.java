package com.academy.academy_dt.dto;

public class CourseResponse {

    private Long id;
    private String name;
    private String description;
    private Integer credits;
    private Long instructorId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCredits() {
        return credits;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
}