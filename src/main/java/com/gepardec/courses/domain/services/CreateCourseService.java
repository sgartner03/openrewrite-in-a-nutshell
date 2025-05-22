package com.gepardec.courses.domain.services;

import com.gepardec.courses.domain.model.Course;
import com.gepardec.courses.domain.ports.inbound.CreateCoursePort;
import com.gepardec.courses.domain.ports.outbound.StoreCoursePort;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateCourseService implements CreateCoursePort {
    @Inject
    private StoreCoursePort storeCoursePort;

    public CreateCourseService() {}

    @Override
    public void createCourse(Course course) {
        storeCoursePort.storeCourse(course);
    }
}
