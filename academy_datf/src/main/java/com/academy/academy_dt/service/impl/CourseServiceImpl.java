package com.academy.academy_dt.service.impl;

import com.academy.academy_dt.dto.CourseResponse;
import com.academy.academy_dt.dto.CreateCourseRequest;
import com.academy.academy_dt.entity.Course;
import com.academy.academy_dt.entity.Instructor;
import com.academy.academy_dt.repository.CourseRepository;
import com.academy.academy_dt.repository.InstructorRepository;
import com.academy.academy_dt.service.CourseService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final InstructorRepository instructorRepository;

    public CourseServiceImpl(CourseRepository repository, InstructorRepository instructorRepository) {
        this.repository = repository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public CourseResponse create(CreateCourseRequest request) {

        Course c = new Course();
        c.setName(request.getName());
        c.setDescription(request.getDescription());
        c.setCredits(request.getCredits());

        if (request.getInstructorId() != null) {

            Instructor instructor = instructorRepository.findById(request.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor " + request.getInstructorId() + " not found"));

            c.setInstructor(instructor);
        }

        Course saved = repository.save(c);

        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private CourseResponse toResponse(Course c) {

        CourseResponse r = new CourseResponse();
        r.setId(c.getId());
        r.setName(c.getName());
        r.setDescription(c.getDescription());
        r.setCredits(c.getCredits());

        if (c.getInstructor() != null) {
            r.setInstructorId(c.getInstructor().getId());
        }

        return r;
    }
}