package com.gepardec.courses.domain.ports.outbound;

import com.gepardec.courses.domain.model.Course;

public interface StoreCoursePort {
    void storeCourse(Course course);
}
