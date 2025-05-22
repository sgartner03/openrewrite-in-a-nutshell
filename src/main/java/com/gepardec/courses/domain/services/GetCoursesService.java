package com.gepardec.courses.domain.services;

import com.gepardec.courses.domain.model.Course;
import com.gepardec.courses.domain.ports.inbound.GetCoursesPort;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetCoursesService implements GetCoursesPort {

    @Inject
    private GetCoursesPort getCoursesPort;

    @Override
    public List<Course> listCourses() {
        return getCoursesPort.listCourses();
    }
}
