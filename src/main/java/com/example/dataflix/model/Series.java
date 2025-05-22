package com.example.dataflix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    private Integer seriesId;

    @Column(name = "series_name")
    private String seriesName;

    @Column(name = "season_count")
    private Integer seasonCount;

    @Column(name = "episode_count")
    private Integer episodeCount;

    @Column(name = "ongoing")
    private Boolean ongoing;

    @Column(name = "type")
    private String type;

    @Column(name = "imdb", nullable = false)
    private Double imdb;

    @Column(name = "age_requirement")
    private Integer ageRequirement;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "description")
    private String description;

    // Getters and setters
    public Integer getSeriesId() { return seriesId; }
    public void setSeriesId(Integer seriesId) { this.seriesId = seriesId; }
    public String getSeriesName() { return seriesName; }
    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }
    public Integer getSeasonCount() { return seasonCount; }
    public void setSeasonCount(Integer seasonCount) { this.seasonCount = seasonCount; }
    public Integer getEpisodeCount() { return episodeCount; }
    public void setEpisodeCount(Integer episodeCount) { this.episodeCount = episodeCount; }
    public Boolean getOngoing() { return ongoing; }
    public void setOngoing(Boolean ongoing) { this.ongoing = ongoing; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Double getImdb() { return imdb; }
    public void setImdb(Double imdb) { this.imdb = imdb; }
    public Integer getAgeRequirement() { return ageRequirement; }
    public void setAgeRequirement(Integer ageRequirement) { this.ageRequirement = ageRequirement; }
    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
} 