package com.gepardec.courses.domain.ports.outbound;

import com.gepardec.courses.domain.exception.CourseNotFoundException;
import com.gepardec.courses.domain.model.Course;

public interface UpdateCoursePort {
    void updateCourse(int courseId, Course course) throws CourseNotFoundException;
}
