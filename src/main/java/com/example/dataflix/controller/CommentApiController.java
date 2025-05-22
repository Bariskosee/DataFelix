package com.example.dataflix.controller;

import com.example.dataflix.dto.MovieCommentDto;
import com.example.dataflix.dto.SeriesCommentDto;
import com.example.dataflix.model.MovieComment;
import com.example.dataflix.model.SeriesComment;
import com.example.dataflix.model.Users;
import com.example.dataflix.repository.UsersRepository;
import com.example.dataflix.service.MovieCommentService;
import com.example.dataflix.service.SeriesCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
public class CommentApiController {

    private final MovieCommentService movieCommentService;
    private final SeriesCommentService seriesCommentService;
    private final UsersRepository usersRepository;

    @Autowired
    public CommentApiController(MovieCommentService movieCommentService, 
                               SeriesCommentService seriesCommentService,
                               UsersRepository usersRepository) {
        this.movieCommentService = movieCommentService;
        this.seriesCommentService = seriesCommentService;
        this.usersRepository = usersRepository;
    }

    // Movie comments endpoints
    @GetMapping("/movie/{movieId}")
    public List<MovieCommentDto> getMovieComments(@PathVariable Integer movieId) {
        List<MovieComment> comments = movieCommentService.getCommentsByMovieId(movieId);
        return comments.stream()
                .map(MovieCommentDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/movie/add")
    public ResponseEntity<?> addMovieComment(@RequestParam("movieId") Integer movieId,
                                         @RequestParam("commentText") String commentText) {
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

            MovieComment comment = movieCommentService.addComment(userOpt.get(), movieId, commentText);
            MovieCommentDto commentDto = new MovieCommentDto(comment);
            
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

    @DeleteMapping("/movie/delete/{commentId}")
    public ResponseEntity<?> deleteMovieComment(@PathVariable Long commentId) {
        try {
            movieCommentService.deleteComment(commentId);
            
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

    // Series comments endpoints
    @GetMapping("/series/{seriesId}")
    public List<SeriesCommentDto> getSeriesComments(@PathVariable Integer seriesId) {
        List<SeriesComment> comments = seriesCommentService.getCommentsBySeriesId(seriesId);
        return comments.stream()
                .map(SeriesCommentDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/series/add")
    public ResponseEntity<?> addSeriesComment(@RequestParam("seriesId") Integer seriesId,
                                         @RequestParam("commentText") String commentText) {
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

            SeriesComment comment = seriesCommentService.addComment(userOpt.get(), seriesId, commentText);
            SeriesCommentDto commentDto = new SeriesCommentDto(comment);
            
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

    @DeleteMapping("/series/delete/{commentId}")
    public ResponseEntity<?> deleteSeriesComment(@PathVariable Long commentId) {
        try {
            seriesCommentService.deleteComment(commentId);
            
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
