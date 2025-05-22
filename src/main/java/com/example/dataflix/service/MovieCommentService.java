package com.example.dataflix.service;

import com.example.dataflix.model.Movie;
import com.example.dataflix.model.MovieComment;
import com.example.dataflix.model.Users;
import com.example.dataflix.repository.MovieCommentRepository;
import com.example.dataflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovieCommentService {

    private final MovieCommentRepository movieCommentRepository;
    private final MovieRepository movieRepository;
    
    @Autowired
    public MovieCommentService(MovieCommentRepository movieCommentRepository, MovieRepository movieRepository) {
        this.movieCommentRepository = movieCommentRepository;
        this.movieRepository = movieRepository;
    }
    
    public MovieComment addComment(Users user, Integer movieId, String commentText) {
        Optional<Movie> movieOpt = movieRepository.findById(movieId);
        if (movieOpt.isEmpty()) {
            throw new RuntimeException("Movie not found");
        }
        
        MovieComment comment = new MovieComment();
        comment.setUser(user);
        comment.setMovie(movieOpt.get());
        comment.setCommentText(commentText);
        comment.setCreatedAt(LocalDateTime.now());
        
        return movieCommentRepository.save(comment);
    }
    
    public List<MovieComment> getCommentsByMovieId(Integer movieId) {
        return movieCommentRepository.findByMovieMovieIdOrderByCreatedAtDesc(movieId);
    }
    
    public void deleteComment(Long commentId) {
        movieCommentRepository.deleteById(commentId);
    }
}
