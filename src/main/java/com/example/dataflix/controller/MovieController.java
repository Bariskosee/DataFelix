package com.example.dataflix.controller;

import com.example.dataflix.model.Movie;
import com.example.dataflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable Integer id, Model model) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        model.addAttribute("movie", movie);
        return "movie-detail";
    }
} 