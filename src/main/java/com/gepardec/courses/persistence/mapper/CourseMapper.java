package com.gepardec.courses.persistence.mapper;

import com.gepardec.courses.domain.model.Course;
import com.gepardec.courses.domain.model.Member;
import com.gepardec.courses.persistence.entity.CourseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {
    public static Course map(CourseEntity courseEntity) {
        List<Member> attendees = courseEntity.getAttendees()
                .stream()
                .map(MemberMapper::map)
                .collect(Collectors.toList());
        return new Course(
                courseEntity.getTitle(),
                courseEntity.getDescription(),
                courseEntity.getInstructor(),
                courseEntity.getCapacity(),
                attendees
        );
    }

    public static CourseEntity map(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setTitle(course.getTitle());
        courseEntity.setDescription(course.getDescription());
        courseEntity.setInstructor(course.getInstructor());
        courseEntity.setCapacity(course.getCapacity());
        return courseEntity;
    }
}
