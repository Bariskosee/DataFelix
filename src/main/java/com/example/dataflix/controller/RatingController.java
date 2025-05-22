package com.example.dataflix.controller;

import com.example.dataflix.model.Rating;
import com.example.dataflix.service.RatingService;
import com.example.dataflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private UserService userService;

    @GetMapping("/check/{contentType}/{contentId}")
    public ResponseEntity<?> checkRating(
            @PathVariable String contentType,
            @PathVariable Integer contentId,
            Principal principal) {
        
        if (principal == null) {
            return ResponseEntity.ok(Map.of("rating", 0));
        }
        
        Integer userId = userService.getCurrentUserId(principal).intValue();
        Optional<Rating> rating = ratingService.getUserRating(userId, contentId, contentType);
        
        Map<String, Object> response = new HashMap<>();
        response.put("rating", rating.isPresent() ? rating.get().getRating() : 0);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/rate/{contentType}/{contentId}")
    public ResponseEntity<?> rateContent(
            @PathVariable String contentType,
            @PathVariable Integer contentId,
            @RequestParam Integer rating,
            Principal principal) {
        
        if (principal == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "User not logged in"));
        }
        
        Integer userId = userService.getCurrentUserId(principal).intValue();
        
        try {
            Rating savedRating = ratingService.rateContent(userId, contentId, contentType, rating);
            double averageRating = ratingService.getAverageRating(contentId, contentType);
            
            Map<String, Object> response = new HashMap<>();
            response.put("rating", savedRating.getRating());
            response.put("averageRating", averageRating);
            
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/remove/{contentType}/{contentId}")
    public ResponseEntity<?> removeRating(
            @PathVariable String contentType,
            @PathVariable Integer contentId,
            Principal principal) {
        
        if (principal == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "User not logged in"));
        }
        
        Integer userId = userService.getCurrentUserId(principal).intValue();
        ratingService.removeRating(userId, contentId, contentType);
        
        double averageRating = ratingService.getAverageRating(contentId, contentType);
        return ResponseEntity.ok(Map.of("averageRating", averageRating));
    }

    @GetMapping("/average/{contentType}/{contentId}")
    public ResponseEntity<?> getAverageRating(
            @PathVariable String contentType,
            @PathVariable Integer contentId) {
        
        double averageRating = ratingService.getAverageRating(contentId, contentType);
        return ResponseEntity.ok(Map.of("averageRating", averageRating));
    }
}
