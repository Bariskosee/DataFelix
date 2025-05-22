package com.example.dataflix.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "watchlist")
@IdClass(WatchlistId.class)
public class Watchlist {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "content_id")
    private Integer contentId;

    @Id
    @Column(name = "content_type")
    private String contentType;

    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    public Watchlist() {
    }

    public Watchlist(Integer userId, Integer contentId, String contentType) {
        this.userId = userId;
        this.contentId = contentId;
        this.contentType = contentType;
        this.addedDate = new Date();
    }

    // We don't have an id field anymore as we use a composite key
    // Use the getters and setters for the key fields instead

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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
