package com.gepardec.courses.persistence;

import com.gepardec.courses.domain.model.Course;
import com.gepardec.courses.domain.ports.outbound.RetrieveCoursesPort;
import com.gepardec.courses.persistence.entity.CourseEntity;
import com.gepardec.courses.persistence.mapper.CourseMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RetrieveCoursesRepository implements RetrieveCoursesPort {

    @Inject
    EntityManager entityManager;

    @Override
    public List<Course> retrieveCourses() {
        return entityManager.createQuery("SELECT c FROM CourseEntity c", CourseEntity.class)
                .getResultList()
                .stream()
                .map(CourseMapper::map)
                .collect(Collectors.toList());
    }
}
