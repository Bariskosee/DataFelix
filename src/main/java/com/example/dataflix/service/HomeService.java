package com.example.dataflix.service;

import com.example.dataflix.model.Movie;
import com.example.dataflix.model.Series;
import com.example.dataflix.repository.MovieRepository;
import com.example.dataflix.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dataflix.dto.ContentDTO;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import com.example.dataflix.dto.MovieSeriesDTO;

@Service
public class HomeService {
    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;

    @Autowired
    public HomeService(MovieRepository movieRepository, SeriesRepository seriesRepository) {
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
    }

    public List<Movie> getRandomMovies(int count) {
        return movieRepository.findRandomMovies(count);
    }

    public List<Series> getRandomSeries(int count) {
        return seriesRepository.findRandomSeries(count);
    }

    public List<ContentDTO> getRandomMixedContent(int movieCount, int seriesCount) {
        List<Movie> movies = getRandomMovies(movieCount);
        List<Series> series = getRandomSeries(seriesCount);
        List<ContentDTO> contentList = new ArrayList<>();
        for (Movie m : movies) {
            contentList.add(new ContentDTO(
                m.getPosterUrl(),
                m.getMovieName(),
                m.getImdb(),
                m.getDescription(),
                "/movies/" + m.getMovieId()
            ));
        }
        for (Series s : series) {
            contentList.add(new ContentDTO(
                s.getPosterUrl(),
                s.getSeriesName(),
                s.getImdb(),
                s.getDescription(),
                "/series/" + s.getSeriesId()
            ));
        }
        Collections.shuffle(contentList);
        return contentList;
    }

    public List<MovieSeriesDTO> searchMoviesAndSeries(String query) {
        List<Movie> movies = movieRepository.findByMovieNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
        List<Series> series = seriesRepository.findBySeriesNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
        List<MovieSeriesDTO> results = new ArrayList<>();
        for (Movie m : movies) {
            results.add(new MovieSeriesDTO(
                m.getPosterUrl(),
                m.getMovieName(),
                m.getImdb(),
                m.getDescription(),
                "/movies/" + m.getMovieId()
            ));
        }
        for (Series s : series) {
            results.add(new MovieSeriesDTO(
                s.getPosterUrl(),
                s.getSeriesName(),
                s.getImdb(),
                s.getDescription(),
                "/series/" + s.getSeriesId()
            ));
        }
        Collections.shuffle(results);
        return results;
    }
} 