package com.gepardec.courses.domain.services;

import com.gepardec.courses.domain.exception.CourseNotFoundException;
import com.gepardec.courses.domain.model.Course;
import com.gepardec.courses.domain.model.Member;
import com.gepardec.courses.domain.ports.inbound.AssignMemberPort;
import com.gepardec.courses.domain.ports.outbound.GetCoursePort;
import com.gepardec.courses.domain.ports.outbound.GetMemberPort;
import com.gepardec.courses.domain.ports.outbound.UpdateCoursePort;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AssignMemberService implements AssignMemberPort {
    @Inject
    private UpdateCoursePort updateCoursePort;

    @Inject
    private GetCoursePort getCoursePort;

    @Inject
    private GetMemberPort getMemberPort;

    public AssignMemberService() {}

    @Override
    public Course assignMemberToCourse(int courseId, int memberId) throws CourseNotFoundException {
        Course course = getCoursePort.getCourse(courseId);
        Member member = getMemberPort.getMember(memberId);
        course.addAttendee(member);

        updateCoursePort.updateCourse(courseId, course);

        return course;
    }
}
