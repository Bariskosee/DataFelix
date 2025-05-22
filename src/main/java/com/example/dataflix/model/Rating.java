package com.example.dataflix.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ratings")
@IdClass(RatingId.class)
public class Rating {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "content_id")
    private Integer contentId;

    @Id
    @Column(name = "content_type")
    private String contentType;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "rated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ratedAt;

    public Rating() {
        this.ratedAt = new Date();
    }

    public Rating(Integer userId, Integer contentId, String contentType, Integer rating) {
        this.userId = userId;
        this.contentId = contentId;
        this.contentType = contentType;
        this.rating = rating;
        this.ratedAt = new Date();
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(Date ratedAt) {
        this.ratedAt = ratedAt;
    }
}
