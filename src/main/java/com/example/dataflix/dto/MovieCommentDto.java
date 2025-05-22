package com.example.dataflix.dto;

import com.example.dataflix.model.MovieComment;
import java.time.LocalDateTime;

public class MovieCommentDto {
    private Long commentId;
    private Long userId;
    private String userEmail;
    private Integer movieId;
    private String commentText;
    private LocalDateTime createdAt;

    // Default constructor
    public MovieCommentDto() {
    }

    // Constructor from MovieComment entity
    public MovieCommentDto(MovieComment comment) {
        this.commentId = comment.getCommentId();
        this.userId = comment.getUser().getUserId();
        this.userEmail = comment.getUser().getEmail();
        this.movieId = comment.getMovie().getMovieId();
        this.commentText = comment.getCommentText();
        this.createdAt = comment.getCreatedAt();
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

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
