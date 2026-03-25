package com.academy.academy_dt.controller;

import com.academy.academy_dt.dto.CourseResponse;
import com.academy.academy_dt.dto.CreateCourseRequest;
import com.academy.academy_dt.service.CourseService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse create(@Valid @RequestBody CreateCourseRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<CourseResponse> list() {
        return service.list();
    }
}