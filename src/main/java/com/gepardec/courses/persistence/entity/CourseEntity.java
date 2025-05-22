package com.gepardec.courses.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;

@Entity
public class CourseEntity {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String instructor;

    @ManyToMany
    private List<MemberEntity> attendees;
    private int capacity;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public List<MemberEntity> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<MemberEntity> attendees) {
        this.attendees = attendees;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
