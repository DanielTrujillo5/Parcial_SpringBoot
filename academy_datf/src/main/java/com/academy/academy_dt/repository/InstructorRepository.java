package com.academy.academy_dt.repository;

import com.academy.academy_dt.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}