package com.mh.api.MhAPI.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_course_set")
@IdClass(EnrollementId.class )
public class Enrollement {

    @ManyToOne
    @Id
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @Id
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDate enrollementDate;

    public Enrollement() {
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrollementDate() {
        return enrollementDate;
    }

    public void setEnrollementDate(LocalDate enrollementDate) {
        this.enrollementDate = enrollementDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
