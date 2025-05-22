package com.gepardec.courses.domain.ports.inbound;

import com.gepardec.courses.domain.model.Course;

public interface CreateCoursePort {
    void createCourse(Course course);
}
