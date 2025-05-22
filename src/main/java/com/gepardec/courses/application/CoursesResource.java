package com.gepardec.courses.application;

import com.gepardec.courses.domain.exception.CourseNotFoundException;
import com.gepardec.courses.domain.model.Course;
import com.gepardec.courses.domain.ports.inbound.AssignMemberPort;
import com.gepardec.courses.domain.ports.inbound.CreateCoursePort;
import com.gepardec.courses.domain.ports.inbound.GetCoursesPort;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/courses")
public class CoursesResource {
    @Inject
    private GetCoursesPort getCoursesPort;

    @Inject
    private CreateCoursePort createCoursePort;

    @Inject
    private AssignMemberPort assignMemberPort;

    @GET
    public List<Course> getCourses() {
        return getCoursesPort.listCourses();
    }

    @POST
    public Course createCourse(Course course) {
        createCoursePort.createCourse(course);
        return course;
    }

    @Path("{courseId}/assign/{memberId}")
    @POST
    public Response assignMember(@PathParam("courseId") String course, @PathParam("memberId") String memberId) {
        try {
            Course entity = assignMemberPort.assignMemberToCourse(Integer.parseInt(course), Integer.parseInt(memberId));
            return Response.ok(entity).build();
        } catch (CourseNotFoundException e) {
            return Response.notModified("Course not found").build();
        }
    }
}
