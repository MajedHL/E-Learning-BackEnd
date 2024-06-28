package com.mh.api.MhAPI.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_quizz_set")
@IdClass(ExamedId.class)
public class Examed {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "quizz_id")
    private Quizz quizz;

    private Double score;


    public Examed() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
