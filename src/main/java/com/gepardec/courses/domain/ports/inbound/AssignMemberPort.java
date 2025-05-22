package com.gepardec.courses.domain.ports.inbound;

import com.gepardec.courses.domain.exception.CourseNotFoundException;
import com.gepardec.courses.domain.model.Course;

public interface AssignMemberPort {
    Course assignMemberToCourse(int courseId, int memberId) throws CourseNotFoundException;
}
