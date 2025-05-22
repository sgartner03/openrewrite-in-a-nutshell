package com.gepardec.courses.persistence;

import com.gepardec.courses.domain.model.Course;
import com.gepardec.courses.domain.ports.outbound.StoreCoursePort;
import com.gepardec.courses.persistence.mapper.CourseMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StoreCourseRepository implements StoreCoursePort {

    @Inject
    EntityManager entityManager;

    @Override
    public void storeCourse(Course course) {
        entityManager.persist(CourseMapper.map(course));
    }
}
