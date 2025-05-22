package com.example.dataflix.model;

import java.io.Serializable;
import java.util.Objects;

public class RatingId implements Serializable {
    private Integer userId;
    private Integer contentId;
    private String contentType;

    public RatingId() {
    }

    public RatingId(Integer userId, Integer contentId, String contentType) {
        this.userId = userId;
        this.contentId = contentId;
        this.contentType = contentType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingId that = (RatingId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(contentId, that.contentId) &&
                Objects.equals(contentType, that.contentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, contentId, contentType);
    }
}
