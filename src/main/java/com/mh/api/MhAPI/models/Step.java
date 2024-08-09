package com.mh.api.MhAPI.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "step")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne
   @JoinColumn(name = "course_id")
    private Course course;

   private Integer orderNumber;

   @OneToMany(mappedBy = "step")
   private List<Content> contentList;


    public Step() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCours() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getorderNumber() {
        return orderNumber;
    }

    public void setorderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }


}
