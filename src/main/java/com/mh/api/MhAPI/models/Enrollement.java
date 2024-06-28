package com.mh.api.MhAPI.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_cours_set")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
