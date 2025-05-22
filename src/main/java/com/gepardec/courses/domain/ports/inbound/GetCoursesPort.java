package com.gepardec.courses.domain.ports.inbound;

import com.gepardec.courses.domain.model.Course;

import java.util.List;

public interface GetCoursesPort {
    List<Course> listCourses();
}
