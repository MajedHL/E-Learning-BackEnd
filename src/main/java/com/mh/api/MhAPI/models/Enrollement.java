package com.mh.api.MhAPI.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "student_cours")
@IdClass(EnrollementId.class )
public class Enrollement {

    @ManyToOne
    @Id
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @Id
    @JoinColumn(name = "cours_id")
    private Cours cours;

    private LocalDate enrollementDate;

    public Enrollement() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public LocalDate getEnrollementDate() {
        return enrollementDate;
    }

    public void setEnrollementDate(LocalDate enrollementDate) {
        this.enrollementDate = enrollementDate;
    }
}
