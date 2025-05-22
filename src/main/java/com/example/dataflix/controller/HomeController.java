package com.example.dataflix.controller;

import com.example.dataflix.model.Movie;
import com.example.dataflix.model.Series;
import com.example.dataflix.service.HomeService;
import com.example.dataflix.dto.ContentDTO;
import com.example.dataflix.dto.MovieSeriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        List<ContentDTO> contentList = homeService.getRandomMixedContent(6, 6);
        model.addAttribute("contentList", contentList);
        return "index";
    }

    @GetMapping("/home")
    public String homeRedirect() {
        return "redirect:/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<MovieSeriesDTO> results = homeService.searchMoviesAndSeries(query);
        model.addAttribute("query", query);
        model.addAttribute("results", results);
        return "search-results";
    }
} 