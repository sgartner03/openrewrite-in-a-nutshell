package com.gepardec.courses.domain.ports.outbound;

import com.gepardec.courses.domain.model.Course;

public interface GetCoursePort {
    Course getCourse(int courseId);
}
