package com.gepardec.courses.domain.ports.outbound;

import com.gepardec.courses.domain.model.Course;

import java.util.List;

public interface RetrieveCoursesPort {
    List<Course> retrieveCourses();
}
