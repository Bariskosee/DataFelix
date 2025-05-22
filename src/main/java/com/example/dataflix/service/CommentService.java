package com.example.dataflix.service;

import com.example.dataflix.model.Comment;
import com.example.dataflix.model.Users;
import com.example.dataflix.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    
    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    
    public Comment addComment(Users user, String content, String contentType, Long contentId) {
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setContent(content);
        comment.setContentType(contentType);
        comment.setContentId(contentId);
        comment.setCreatedAt(LocalDateTime.now());
        
        return commentRepository.save(comment);
    }
    
    public List<Comment> getCommentsByContent(String contentType, Long contentId) {
        return commentRepository.findByContentTypeAndContentIdOrderByCreatedAtDesc(contentType, contentId);
    }
    
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
