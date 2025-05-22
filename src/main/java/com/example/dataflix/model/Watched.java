package com.example.dataflix.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "watched")
@IdClass(WatchedId.class)
public class Watched {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "content_id")
    private Integer contentId;

    @Id
    @Column(name = "content_type")
    private String contentType;

    @Column(name = "watch_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date watchDate;

    public Watched() {
    }

    public Watched(Integer userId, Integer contentId, String contentType) {
        this.userId = userId;
        this.contentId = contentId;
        this.contentType = contentType;
        this.watchDate = new Date();
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

    public Date getWatchDate() {
        return watchDate;
    }

    public void setWatchDate(Date watchDate) {
        this.watchDate = watchDate;
    }
}
