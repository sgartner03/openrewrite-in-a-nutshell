package com.gepardec.courses.domain.exception;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String member) {
        super("Member " + member + " not found");
    }
}
