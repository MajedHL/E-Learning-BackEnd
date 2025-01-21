package com.mh.api.MhAPI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    private String description;

    private LocalDate openingDate;
    private LocalDate closingDate;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Quizz> quizzList;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Step> stepList;

   @Transient
    private Boolean isOpen;
    @Transient
    private Boolean isClosed;

    @Version
    @Column(nullable = false)
    private int version;


    public Boolean getIsClosed() {
        LocalDate today =  LocalDate.now();
        if(closingDate == null) return false;
        isClosed = today.isAfter(closingDate);
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Course() {
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


    public Boolean getIsOpen() {
        LocalDate today =  LocalDate.now();
        if(openingDate == null) return true;
        isOpen = today.isAfter(openingDate) && today.isBefore(closingDate);
        return isOpen;
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
