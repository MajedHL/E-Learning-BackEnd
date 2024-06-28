package com.mh.api.MhAPI.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private LocalDate openingDate;
    private LocalDate closingDate;

    @OneToMany(mappedBy = "cours")
    private List<Quizz> quizzList;

    @OneToMany(mappedBy = "cours")
    private List<Step> stepList;
   @Transient
    private Boolean isOpen;

    @Version
    @Column(nullable = false)
    private int version;

    public Cours() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public Boolean getOpen() {
        LocalDate today =  LocalDate.now();
        return today.isAfter(openingDate) && today.isBefore(closingDate);
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Quizz> getQuizzList() {
        return quizzList;
    }

    public void setQuizzList(List<Quizz> quizzList) {
        this.quizzList = quizzList;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }


}
