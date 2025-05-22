package com.gepardec.courses.persistence;

import com.gepardec.courses.domain.exception.CourseNotFoundException;
import com.gepardec.courses.domain.model.Course;
import com.gepardec.courses.domain.model.Member;
import com.gepardec.courses.domain.ports.outbound.UpdateCoursePort;
import com.gepardec.courses.persistence.entity.CourseEntity;
import com.gepardec.courses.persistence.entity.MemberEntity;
import com.gepardec.courses.persistence.mapper.MemberMapper;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class UpdateCourseRepository implements UpdateCoursePort {

    @Inject
    EntityManager entityManager;

    @Override
    public void updateCourse(int courseId, Course course) throws CourseNotFoundException {
        CourseEntity existingCourse = entityManager.find(CourseEntity.class, courseId);
        if (existingCourse == null) {
            throw new CourseNotFoundException("" + courseId);
        }
        List<MemberEntity> attendees = course.getAttendees().stream()
                    .map(MemberMapper::map)
                    .collect(Collectors.toList());

        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setAttendees(attendees);
        existingCourse.setCapacity(course.getCapacity());
        existingCourse.setInstructor(course.getInstructor());

        entityManager.merge(existingCourse);
    }
}
