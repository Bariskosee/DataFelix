package com.example.dataflix.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie_favorites")
@IdClass(MovieFavoriteId.class)
public class MovieFavorite implements Serializable {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "added_date")
    private String addedDate;

    // Getters and setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Integer getMovieId() { return movieId; }
    public void setMovieId(Integer movieId) { this.movieId = movieId; }
    public String getAddedDate() { return addedDate; }
    public void setAddedDate(String addedDate) { this.addedDate = addedDate; }
} 