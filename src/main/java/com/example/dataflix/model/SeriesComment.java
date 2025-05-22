package com.example.dataflix.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "series_comments")
public class SeriesComment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    
    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;
    
    @Column(name = "comment_text", nullable = false, length = 1000)
    private String commentText;
    
    @Column(name = "comment_date", nullable = false)
    private LocalDateTime commentDate;
    
    // Constructors
    public SeriesComment() {
        this.commentDate = LocalDateTime.now();
    }
    
    public SeriesComment(Users user, Series series, String commentText) {
        this.user = user;
        this.series = series;
        this.commentText = commentText;
        this.commentDate = LocalDateTime.now();
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

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
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
