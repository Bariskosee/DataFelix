package com.example.dataflix.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "series_favorites")
@IdClass(SeriesFavoriteId.class)
public class SeriesFavorite implements Serializable {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "series_id")
    private Integer seriesId;

    @Column(name = "added_date")
    private Date addedDate;

    // Getters and setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Integer getSeriesId() { return seriesId; }
    public void setSeriesId(Integer seriesId) { this.seriesId = seriesId; }
    public Date getAddedDate() { return addedDate; }
    public void setAddedDate(Date addedDate) { this.addedDate = addedDate; }
} 