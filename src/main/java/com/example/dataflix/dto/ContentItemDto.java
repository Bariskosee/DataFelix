package com.example.dataflix.dto;

public class ContentItemDto {
    private Integer contentId;
    private String contentType;
    private String title;
    private String posterUrl;
    private Double imdb;
    private String description;

    public ContentItemDto() {
    }

    public ContentItemDto(Integer contentId, String contentType, String title, String posterUrl, Double imdb, String description) {
        this.contentId = contentId;
        this.contentType = contentType;
        this.title = title;
        this.posterUrl = posterUrl;
        this.imdb = imdb;
        this.description = description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Double getImdb() {
        return imdb;
    }

    public void setImdb(Double imdb) {
        this.imdb = imdb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
