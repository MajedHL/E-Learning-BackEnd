package com.mh.api.MhAPI.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_cours")
@IdClass(EnrollementId.class )
public class Enrollement {

    @ManyToOne
    @Id
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @Id
    @JoinColumn(name = "cours_id")
    private Cours cours;

    private LocalDate enrollementDate;

    public Enrollement() {
    }

    public User getStudent() {
        return user;
    }

    public void setStudent(User user) {
        this.user = user;
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
