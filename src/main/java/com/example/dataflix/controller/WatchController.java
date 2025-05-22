package com.example.dataflix.controller;

import com.example.dataflix.service.UserService;
import com.example.dataflix.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/watch")
public class WatchController {

    @Autowired
    private WatchService watchService;

    @Autowired
    private UserService userService;

    // Watchlist endpoints
    @GetMapping("/watchlist/check/{contentType}/{contentId}")
    public ResponseEntity<?> checkWatchlistStatus(
            @PathVariable String contentType,
            @PathVariable Integer contentId,
            Principal principal) {
        Integer userId = userService.getCurrentUserId(principal).intValue();
        boolean isInWatchlist = watchService.isInWatchlist(userId, contentId, contentType);
        
        Map<String, Object> response = new HashMap<>();
        response.put("inWatchlist", isInWatchlist);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/watchlist/add/{contentType}/{contentId}")
    public ResponseEntity<?> addToWatchlist(
            @PathVariable String contentType,
            @PathVariable Integer contentId,
            Principal principal) {
        Integer userId = userService.getCurrentUserId(principal).intValue();
        watchService.addToWatchlist(userId, contentId, contentType);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Added to watchlist");
        
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/watchlist/remove/{contentType}/{contentId}")
    public ResponseEntity<?> removeFromWatchlist(
            @PathVariable String contentType,
            @PathVariable Integer contentId,
            Principal principal) {
        Integer userId = userService.getCurrentUserId(principal).intValue();
        watchService.removeFromWatchlist(userId, contentId, contentType);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Removed from watchlist");
        
        return ResponseEntity.ok(response);
    }

    // Watched endpoints
    @GetMapping("/watched/check/{contentType}/{contentId}")
    public ResponseEntity<?> checkWatchedStatus(
            @PathVariable String contentType,
            @PathVariable Integer contentId,
            Principal principal) {
        Integer userId = userService.getCurrentUserId(principal).intValue();
        boolean isWatched = watchService.isInWatchedList(userId, contentId, contentType);
        
        Map<String, Object> response = new HashMap<>();
        response.put("isWatched", isWatched);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/watched/add/{contentType}/{contentId}")
    public ResponseEntity<?> markAsWatched(
            @PathVariable String contentType,
            @PathVariable Integer contentId,
            Principal principal) {
        Integer userId = userService.getCurrentUserId(principal).intValue();
        watchService.markAsWatched(userId, contentId, contentType);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Marked as watched");
        
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/watched/remove/{contentType}/{contentId}")
    public ResponseEntity<?> removeFromWatched(
            @PathVariable String contentType,
            @PathVariable Integer contentId,
            Principal principal) {
        Integer userId = userService.getCurrentUserId(principal).intValue();
        watchService.removeFromWatched(userId, contentId, contentType);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Removed from watched list");
        
        return ResponseEntity.ok(response);
    }
}
