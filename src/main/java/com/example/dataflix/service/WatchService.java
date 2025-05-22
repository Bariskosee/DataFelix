package com.example.dataflix.service;

import com.example.dataflix.dto.ContentItemDto;
import com.example.dataflix.model.Movie;
import com.example.dataflix.model.Series;
import com.example.dataflix.model.Watched;
import com.example.dataflix.model.Watchlist;
import com.example.dataflix.repository.MovieRepository;
import com.example.dataflix.repository.SeriesRepository;
import com.example.dataflix.repository.WatchedRepository;
import com.example.dataflix.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WatchService {

    @Autowired
    private WatchlistRepository watchlistRepository;
    
    @Autowired
    private WatchedRepository watchedRepository;
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private SeriesRepository seriesRepository;

    // Watchlist methods
    public List<ContentItemDto> getUserWatchlist(Integer userId) {
        List<Watchlist> watchlistItems = watchlistRepository.findByUserId(userId);
        List<ContentItemDto> result = new ArrayList<>();
        
        for (Watchlist item : watchlistItems) {
            ContentItemDto dto = null;
            
            if ("movie".equals(item.getContentType())) {
                Optional<Movie> movie = movieRepository.findById(item.getContentId());
                if (movie.isPresent()) {
                    Movie m = movie.get();
                    dto = new ContentItemDto(
                        m.getMovieId(),
                        "movie",
                        m.getMovieName(),
                        m.getPosterUrl(),
                        m.getImdb(),
                        m.getDescription()
                    );
                }
            } else if ("series".equals(item.getContentType())) {
                Optional<Series> series = seriesRepository.findById(item.getContentId());
                if (series.isPresent()) {
                    Series s = series.get();
                    dto = new ContentItemDto(
                        s.getSeriesId(),
                        "series",
                        s.getSeriesName(),
                        s.getPosterUrl(),
                        s.getImdb(),
                        s.getDescription()
                    );
                }
            }
            
            if (dto != null) {
                result.add(dto);
            }
        }
        
        return result;
    }
    
    public boolean isInWatchlist(Integer userId, Integer contentId, String contentType) {
        return watchlistRepository.findByUserIdAndContentIdAndContentType(userId, contentId, contentType).isPresent();
    }
    
    @Transactional
    public void addToWatchlist(Integer userId, Integer contentId, String contentType) {
        if (!isInWatchlist(userId, contentId, contentType)) {
            Watchlist watchlistItem = new Watchlist(userId, contentId, contentType);
            watchlistRepository.save(watchlistItem);
        }
    }
    
    @Transactional
    public void removeFromWatchlist(Integer userId, Integer contentId, String contentType) {
        watchlistRepository.deleteByUserIdAndContentIdAndContentType(userId, contentId, contentType);
    }
    
    // Watched methods
    public List<ContentItemDto> getUserWatchedList(Integer userId) {
        List<Watched> watchedItems = watchedRepository.findByUserId(userId);
        List<ContentItemDto> result = new ArrayList<>();
        
        for (Watched item : watchedItems) {
            ContentItemDto dto = null;
            
            if ("movie".equals(item.getContentType())) {
                Optional<Movie> movie = movieRepository.findById(item.getContentId());
                if (movie.isPresent()) {
                    Movie m = movie.get();
                    dto = new ContentItemDto(
                        m.getMovieId(),
                        "movie",
                        m.getMovieName(),
                        m.getPosterUrl(),
                        m.getImdb(),
                        m.getDescription()
                    );
                }
            } else if ("series".equals(item.getContentType())) {
                Optional<Series> series = seriesRepository.findById(item.getContentId());
                if (series.isPresent()) {
                    Series s = series.get();
                    dto = new ContentItemDto(
                        s.getSeriesId(),
                        "series",
                        s.getSeriesName(),
                        s.getPosterUrl(),
                        s.getImdb(),
                        s.getDescription()
                    );
                }
            }
            
            if (dto != null) {
                result.add(dto);
            }
        }
        
        return result;
    }
    
    public boolean isInWatchedList(Integer userId, Integer contentId, String contentType) {
        return watchedRepository.findByUserIdAndContentIdAndContentType(userId, contentId, contentType).isPresent();
    }
    
    @Transactional
    public void markAsWatched(Integer userId, Integer contentId, String contentType) {
        if (!isInWatchedList(userId, contentId, contentType)) {
            Watched watchedItem = new Watched(userId, contentId, contentType);
            watchedRepository.save(watchedItem);
        }
    }
    
    @Transactional
    public void removeFromWatched(Integer userId, Integer contentId, String contentType) {
        watchedRepository.deleteByUserIdAndContentIdAndContentType(userId, contentId, contentType);
    }
}
