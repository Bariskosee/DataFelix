package com.example.dataflix.dto;

public class MovieSeriesDTO {
    private String posterUrl;
    private String title;
    private Double imdb;
    private String description;
    private String detailUrl;

    public MovieSeriesDTO(String posterUrl, String title, Double imdb, String description, String detailUrl) {
        this.posterUrl = posterUrl;
        this.title = title;
        this.imdb = imdb;
        this.description = description;
        this.detailUrl = detailUrl;
    }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Double getImdb() { return imdb; }
    public void setImdb(Double imdb) { this.imdb = imdb; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getDetailUrl() { return detailUrl; }
    public void setDetailUrl(String detailUrl) { this.detailUrl = detailUrl; }
} 