package com.gepardec.courses.persistence;

import com.gepardec.courses.domain.model.Course;
import com.gepardec.courses.domain.ports.outbound.GetCoursePort;
import com.gepardec.courses.persistence.entity.CourseEntity;
import com.gepardec.courses.persistence.mapper.CourseMapper;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class GetCourseRepository implements GetCoursePort {
    @Inject
    EntityManager entityManager;

    @Override
    public Course getCourse(int courseId) {
        CourseEntity entity = entityManager.find(CourseEntity.class, courseId);
        return CourseMapper.map(entity);
    }
}
