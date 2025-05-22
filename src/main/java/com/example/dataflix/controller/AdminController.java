package com.example.dataflix.controller;

import com.example.dataflix.model.Movie;
import com.example.dataflix.model.Series;
import com.example.dataflix.repository.MovieRepository;
import com.example.dataflix.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private SeriesRepository seriesRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Admin controller is working!";
    }
    
    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    @GetMapping("/series")
    @ResponseBody
    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    @PostMapping("/update-poster")
    @ResponseBody
    public ResponseEntity<String> updateMoviePoster(
            @RequestParam("movieName") String movieName,
            @RequestParam("posterUrl") String posterUrl) {

        // Find movie by name
        Optional<Movie> movieOpt = movieRepository.findByMovieNameIgnoreCase(movieName);
        
        if (movieOpt.isPresent()) {
            Movie movie = movieOpt.get();
            movie.setPosterUrl(posterUrl);
            movieRepository.save(movie);
            return ResponseEntity.ok("Movie poster updated successfully for: " + movieName);
        } else {
            return ResponseEntity.badRequest().body("Movie not found: " + movieName);
        }
    }
    
    @PostMapping("/update-series-poster")
    @ResponseBody
    public ResponseEntity<String> updateSeriesPoster(
            @RequestParam("seriesName") String seriesName,
            @RequestParam("posterUrl") String posterUrl) {

        // Find series by name
        Optional<Series> seriesOpt = seriesRepository.findBySeriesNameIgnoreCase(seriesName);
        
        if (seriesOpt.isPresent()) {
            Series series = seriesOpt.get();
            series.setPosterUrl(posterUrl);
            seriesRepository.save(series);
            return ResponseEntity.ok("Series poster updated successfully for: " + seriesName);
        } else {
            return ResponseEntity.badRequest().body("Series not found: " + seriesName);
        }
    }
} 