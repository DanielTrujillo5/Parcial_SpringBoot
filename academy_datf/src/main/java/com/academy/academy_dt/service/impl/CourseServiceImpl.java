package com.academy.academy_dt.service.impl;

import com.academy.academy_dt.dto.CourseResponse;
import com.academy.academy_dt.dto.CreateCourseRequest;
import com.academy.academy_dt.entity.Course;
import com.academy.academy_dt.repository.CourseRepository;
import com.academy.academy_dt.service.CourseService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseResponse create(CreateCourseRequest request) {

        Course c = new Course();
        c.setName(request.getName());
        c.setDescription(request.getDescription());
        c.setCredits(request.getCredits());

        Course saved = repository.save(c);

        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private CourseResponse toResponse(Course c) {
        CourseResponse r = new CourseResponse();
        r.setId(c.getId());
        r.setName(c.getName());
        r.setDescription(c.getDescription());
        r.setCredits(c.getCredits());
        return r;
    }
}