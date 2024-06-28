package com.mh.api.MhAPI.models;

import jakarta.persistence.*;

@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String title;

    private String url;

    @ManyToOne
    @JoinColumn(name = "step_id")
    private Step step;

    private Integer orderNumber;

    public Content() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public Integer getorderNumber() {
        return orderNumber;
    }

    public void setorderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }


}
