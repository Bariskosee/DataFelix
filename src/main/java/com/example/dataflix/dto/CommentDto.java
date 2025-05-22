package com.example.dataflix.dto;

import com.example.dataflix.model.Comment;
import java.time.LocalDateTime;

public class CommentDto {
    private Long commentId;
    private Long userId;
    private String username;
    private String content;
    private LocalDateTime createdAt;
    private String contentType;
    private Long contentId;

    // Default constructor
    public CommentDto() {
    }

    // Constructor from Comment entity
    public CommentDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.userId = comment.getUser().getUserId();
        this.username = comment.getUser().getEmail(); // Using email instead of username
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.contentType = comment.getContentType();
        this.contentId = comment.getContentId();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
}
