package com.example.dataflix.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "series_id")
    private Integer seriesId;

    @Column(name = "added_date")
    private LocalDateTime addedDate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Integer getMovieId() { return movieId; }
    public void setMovieId(Integer movieId) { this.movieId = movieId; }
    public Integer getSeriesId() { return seriesId; }
    public void setSeriesId(Integer seriesId) { this.seriesId = seriesId; }
    public LocalDateTime getAddedDate() { return addedDate; }
    public void setAddedDate(LocalDateTime addedDate) { this.addedDate = addedDate; }
} 