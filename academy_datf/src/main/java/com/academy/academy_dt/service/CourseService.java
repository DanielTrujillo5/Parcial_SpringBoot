package com.academy.academy_dt.service;

import com.academy.academy_dt.dto.CourseResponse;
import com.academy.academy_dt.dto.CreateCourseRequest;
import java.util.List;

public interface CourseService {

    CourseResponse create(CreateCourseRequest request);

    List<CourseResponse> list();
}