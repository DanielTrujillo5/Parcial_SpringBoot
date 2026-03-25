package com.academy.academy_dt.controller;

import com.academy.academy_dt.entity.Instructor;
import com.academy.academy_dt.repository.InstructorRepository;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorRepository repository;

    public InstructorController(InstructorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Instructor create(@Valid @RequestBody Instructor instructor) {
        return repository.save(instructor);
    }

    @GetMapping
    public List<Instructor> list() {
        return repository.findAll();
    }
}