package com.academy.academy_dt.repository;

import com.academy.academy_dt.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}