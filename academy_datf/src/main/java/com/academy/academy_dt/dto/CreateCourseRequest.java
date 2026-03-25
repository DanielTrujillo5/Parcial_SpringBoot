package com.academy.academy_dt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCourseRequest {

    @NotBlank(message = "name is required")
    @Size(max = 120, message = "name must be <= 120 chars")
    private String name;

    @Size(max = 500, message = "description must be <= 500 chars")
    private String description;

    @NotNull(message = "credits is required")
    private Integer credits;

    private Long instructorId;

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