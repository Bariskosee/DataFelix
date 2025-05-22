package com.example.dataflix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id")
    private Integer episodeId;

    @Column(name = "season_id")
    private Integer seasonId;

    @Column(name = "episode_number")
    private Integer episodeNumber;

    @Column(name = "episode_title")
    private String episodeTitle;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "release_date")
    private java.sql.Date releaseDate;

    // Getters and setters
    public Integer getEpisodeId() { return episodeId; }
    public void setEpisodeId(Integer episodeId) { this.episodeId = episodeId; }
    public Integer getSeasonId() { return seasonId; }
    public void setSeasonId(Integer seasonId) { this.seasonId = seasonId; }
    public Integer getEpisodeNumber() { return episodeNumber; }
    public void setEpisodeNumber(Integer episodeNumber) { this.episodeNumber = episodeNumber; }
    public String getEpisodeTitle() { return episodeTitle; }
    public void setEpisodeTitle(String episodeTitle) { this.episodeTitle = episodeTitle; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public java.sql.Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(java.sql.Date releaseDate) { this.releaseDate = releaseDate; }
} 