package com.mh.api.MhAPI.dto;

import com.mh.api.MhAPI.models.ContentType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContentDTO {

    private  String title;

    private  String text;

    private  String url;

    @NotNull
    private  Integer orderNumber;

    private  Long stepId;
    @NotNull
    private ContentType type;

    public ContentDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public ContentType getType() {
        return type;
    }

    public void setType(ContentType type) {
        this.type = type;
    }
}
