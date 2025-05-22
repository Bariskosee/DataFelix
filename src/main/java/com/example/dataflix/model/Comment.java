package com.example.dataflix.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    
    @Column(name = "content", nullable = false, length = 1000)
    private String content;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "content_type", nullable = false)
    private String contentType; // "movie" or "series"
    
    @Column(name = "content_id", nullable = false)
    private Long contentId; // movie_id or series_id
    
    // Constructors
    public Comment() {
        this.createdAt = LocalDateTime.now();
    }
    
    public Comment(Users user, String content, String contentType, Long contentId) {
        this.user = user;
        this.content = content;
        this.contentType = contentType;
        this.contentId = contentId;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
