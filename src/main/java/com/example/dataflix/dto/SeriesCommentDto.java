package com.example.dataflix.dto;

import com.example.dataflix.model.SeriesComment;
import java.time.LocalDateTime;

public class SeriesCommentDto {
    private Long commentId;
    private Long userId;
    private String userEmail;
    private Integer seriesId;
    private String commentText;
    private LocalDateTime commentDate;

    // Default constructor
    public SeriesCommentDto() {
    }

    // Constructor from SeriesComment entity
    public SeriesCommentDto(SeriesComment comment) {
        this.commentId = comment.getCommentId();
        this.userId = comment.getUser().getUserId();
        this.userEmail = comment.getUser().getEmail();
        this.seriesId = comment.getSeries().getSeriesId();
        this.commentText = comment.getCommentText();
        this.commentDate = comment.getCommentDate();
    }

    // Getters and Setters
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }
}
