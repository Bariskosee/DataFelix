package com.example.dataflix.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movie_comments")
public class MovieComment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    
    @Column(name = "comment_text", nullable = false, length = 1000)
    private String commentText;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    // Constructors
    public MovieComment() {
        this.createdAt = LocalDateTime.now();
    }
    
    public MovieComment(Users user, Movie movie, String commentText) {
        this.user = user;
        this.movie = movie;
        this.commentText = commentText;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
