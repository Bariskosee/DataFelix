package com.example.dataflix.controller;

import com.example.dataflix.dto.CommentDto;
import com.example.dataflix.model.Comment;
import com.example.dataflix.model.Users;
import com.example.dataflix.repository.UsersRepository;
import com.example.dataflix.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final UsersRepository usersRepository;

    @Autowired
    public CommentController(CommentService commentService, UsersRepository usersRepository) {
        this.commentService = commentService;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/{contentType}/{contentId}")
    @ResponseBody
    public List<CommentDto> getComments(@PathVariable String contentType, @PathVariable Long contentId) {
        List<Comment> comments = commentService.getCommentsByContent(contentType, contentId);
        return comments.stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> addComment(@RequestParam("contentType") String contentType,
                                      @RequestParam("contentId") Long contentId,
                                      @RequestParam("content") String content) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = auth.getName(); // Spring Security uses email as the username
            Optional<Users> userOpt = usersRepository.findByEmail(email);

            if (userOpt.isEmpty()) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", false);
                response.put("message", "User not found");
                return ResponseEntity.badRequest().body(response);
            }

            Comment comment = commentService.addComment(userOpt.get(), content, contentType, contentId);
            CommentDto commentDto = new CommentDto(comment);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("comment", commentDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/delete/{commentId}")
    @ResponseBody
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        try {
            commentService.deleteComment(commentId);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
