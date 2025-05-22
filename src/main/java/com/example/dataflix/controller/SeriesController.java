package com.example.dataflix.controller;

import com.example.dataflix.model.Series;
import com.example.dataflix.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SeriesController {
    @Autowired
    private SeriesRepository seriesRepository;

    @GetMapping("/series/{id}")
    public String seriesDetail(@PathVariable Integer id, Model model) {
        Series series = seriesRepository.findById(id).orElseThrow();
        model.addAttribute("series", series);
        return "series-detail";
    }
} 