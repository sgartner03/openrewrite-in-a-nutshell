package com.gepardec.courses.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private String description;
    private String instructor;
    private List<Member> attendees;
    private int capacity;

    public Course(String title, String description, String instructor, int capacity, List<Member> attendees) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.attendees = new ArrayList<>();
        this.capacity = capacity;
        this.attendees = attendees;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructor() {
        return instructor;
    }

    public List<Member> getAttendees() {
        return attendees;
    }

    public void addAttendee(Member attendee) {
        if (attendees.size() >= capacity) {
            throw new IllegalStateException("Max attendees reached");
        }
        attendees.add(attendee);
    }

    public int getCapacity() {
        return capacity;
    }
}
