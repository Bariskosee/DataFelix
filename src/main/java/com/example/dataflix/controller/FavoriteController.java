package com.example.dataflix.controller;

import com.example.dataflix.model.MovieFavorite;
import com.example.dataflix.model.SeriesFavorite;
import com.example.dataflix.repository.MovieFavoriteRepository;
import com.example.dataflix.repository.SeriesFavoriteRepository;
import com.example.dataflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/favorites")
public class FavoriteController {
    
    private static final Logger logger = LoggerFactory.getLogger(FavoriteController.class);

    @Autowired
    private MovieFavoriteRepository movieFavoriteRepository;

    @Autowired
    private SeriesFavoriteRepository seriesFavoriteRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/movie/add/{movieId}")
    public @ResponseBody ResponseEntity<?> addMovieFavorite(@PathVariable Integer movieId, Principal principal) {
        logger.info("Adding movie favorite: movieId={}", movieId);
        try {
            Long userId = userService.getCurrentUserId(principal);
            logger.info("User ID for adding movie favorite: {}", userId);
            Optional<MovieFavorite> existingFavorite = movieFavoriteRepository.findById(new com.example.dataflix.model.MovieFavoriteId(userId, movieId));
            
            if (existingFavorite.isPresent()) {
                logger.info("Movie already in favorites: userId={}, movieId={}", userId, movieId);
                Map<String, Object> response = new HashMap<>();
                response.put("success", false);
                response.put("message", "Movie already in favorites");
                return ResponseEntity.ok(response);
            }
            
            MovieFavorite favorite = new MovieFavorite();
            favorite.setUserId(userId);
            favorite.setMovieId(movieId);
            favorite.setAddedDate(new Date().toString());
            movieFavoriteRepository.save(favorite);
            
            logger.info("Movie added to favorites: userId={}, movieId={}", userId, movieId);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Movie added to favorites");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error adding movie to favorites: movieId={}, error={}", movieId, e.getMessage(), e);
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error adding movie to favorites: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @DeleteMapping("/movie/remove/{movieId}")
    public @ResponseBody ResponseEntity<?> removeMovieFavorite(@PathVariable Integer movieId, Principal principal) {
        logger.info("Removing movie favorite: movieId={}", movieId);
        try {
            Long userId = userService.getCurrentUserId(principal);
            logger.info("User ID for removing movie favorite: {}", userId);
            Optional<MovieFavorite> favorite = movieFavoriteRepository.findById(new com.example.dataflix.model.MovieFavoriteId(userId, movieId));
            
            if (favorite.isPresent()) {
                movieFavoriteRepository.delete(favorite.get());
                logger.info("Movie removed from favorites: userId={}, movieId={}", userId, movieId);
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Movie removed from favorites");
                return ResponseEntity.ok(response);
            } else {
                logger.info("Movie not found in favorites: userId={}, movieId={}", userId, movieId);
                Map<String, Object> response = new HashMap<>();
                response.put("success", false);
                response.put("message", "Movie not found in favorites");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            logger.error("Error removing movie from favorites: movieId={}, error={}", movieId, e.getMessage(), e);
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error removing movie from favorites: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @PostMapping("/series/add/{seriesId}")
    public @ResponseBody ResponseEntity<?> addSeriesFavorite(@PathVariable Integer seriesId, Principal principal) {
        try {
            Long userId = userService.getCurrentUserId(principal);
            Optional<SeriesFavorite> existingFavorite = seriesFavoriteRepository.findById(new com.example.dataflix.model.SeriesFavoriteId(userId, seriesId));
            
            if (existingFavorite.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", false);
                response.put("message", "Series already in favorites");
                return ResponseEntity.ok(response);
            }
            
            SeriesFavorite favorite = new SeriesFavorite();
            favorite.setUserId(userId);
            favorite.setSeriesId(seriesId);
            favorite.setAddedDate(new Date());
            seriesFavoriteRepository.save(favorite);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Series added to favorites");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error adding series to favorites: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @DeleteMapping("/series/remove/{seriesId}")
    public @ResponseBody ResponseEntity<?> removeSeriesFavorite(@PathVariable Integer seriesId, Principal principal) {
        try {
            Long userId = userService.getCurrentUserId(principal);
            Optional<SeriesFavorite> favorite = seriesFavoriteRepository.findById(new com.example.dataflix.model.SeriesFavoriteId(userId, seriesId));
            
            if (favorite.isPresent()) {
                seriesFavoriteRepository.delete(favorite.get());
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Series removed from favorites");
                return ResponseEntity.ok(response);
            } else {
                Map<String, Object> response = new HashMap<>();
                response.put("success", false);
                response.put("message", "Series not found in favorites");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error removing series from favorites: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/movie/check/{movieId}")
    public @ResponseBody ResponseEntity<?> checkMovieFavorite(@PathVariable Integer movieId, Principal principal) {
        logger.info("Checking movie favorite status: movieId={}", movieId);
        try {
            Long userId = userService.getCurrentUserId(principal);
            boolean isFavorite = movieFavoriteRepository.findById(new com.example.dataflix.model.MovieFavoriteId(userId, movieId)).isPresent();
            
            logger.info("Movie favorite check: userId={}, movieId={}, isFavorite={}", userId, movieId, isFavorite);
            Map<String, Object> response = new HashMap<>();
            response.put("isFavorite", isFavorite);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error checking movie favorite status: movieId={}, error={}", movieId, e.getMessage(), e);
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Error checking favorite status: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/series/check/{seriesId}")
    public @ResponseBody ResponseEntity<?> checkSeriesFavorite(@PathVariable Integer seriesId, Principal principal) {
        logger.info("Checking series favorite status: seriesId={}", seriesId);
        try {
            Long userId = userService.getCurrentUserId(principal);
            boolean isFavorite = seriesFavoriteRepository.findById(new com.example.dataflix.model.SeriesFavoriteId(userId, seriesId)).isPresent();
            
            logger.info("Series favorite check: userId={}, seriesId={}, isFavorite={}", userId, seriesId, isFavorite);
            Map<String, Object> response = new HashMap<>();
            response.put("isFavorite", isFavorite);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error checking series favorite status: seriesId={}, error={}", seriesId, e.getMessage(), e);
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Error checking favorite status: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
} 