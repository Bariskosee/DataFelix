package com.example.dataflix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "imdb", nullable = false)
    private Double imdb;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "type")
    private String type;

    @Column(name = "age_requirement")
    private Integer ageRequirement;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "description")
    private String description;

    // Getters and setters
    public Integer getMovieId() { return movieId; }
    public void setMovieId(Integer movieId) { this.movieId = movieId; }
    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }
    public Double getImdb() { return imdb; }
    public void setImdb(Double imdb) { this.imdb = imdb; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Integer getAgeRequirement() { return ageRequirement; }
    public void setAgeRequirement(Integer ageRequirement) { this.ageRequirement = ageRequirement; }
    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
} 