package com.example.dataflix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id")
    private Integer seasonId;

    @Column(name = "series_id")
    private Integer seriesId;

    @Column(name = "season_number")
    private Integer seasonNumber;

    @Column(name = "release_year")
    private Integer releaseYear;

    // Getters and setters
    public Integer getSeasonId() { return seasonId; }
    public void setSeasonId(Integer seasonId) { this.seasonId = seasonId; }
    public Integer getSeriesId() { return seriesId; }
    public void setSeriesId(Integer seriesId) { this.seriesId = seriesId; }
    public Integer getSeasonNumber() { return seasonNumber; }
    public void setSeasonNumber(Integer seasonNumber) { this.seasonNumber = seasonNumber; }
    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
} 