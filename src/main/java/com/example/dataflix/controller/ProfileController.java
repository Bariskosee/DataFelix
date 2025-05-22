package com.example.dataflix.controller;

import com.example.dataflix.model.Like;
import com.example.dataflix.model.Movie;
import com.example.dataflix.model.MovieFavorite;
import com.example.dataflix.model.Series;
import com.example.dataflix.model.SeriesFavorite;
import com.example.dataflix.model.User;
import com.example.dataflix.repository.FavoriteRepository;
import com.example.dataflix.repository.LikeRepository;
import com.example.dataflix.repository.MovieFavoriteRepository;
import com.example.dataflix.repository.MovieRepository;
import com.example.dataflix.repository.SeriesFavoriteRepository;
import com.example.dataflix.repository.SeriesRepository;
import com.example.dataflix.repository.UserRepository;
import com.example.dataflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProfileController {
    @Autowired private FavoriteRepository favoriteRepository;
    @Autowired private MovieFavoriteRepository movieFavoriteRepository;
    @Autowired private SeriesFavoriteRepository seriesFavoriteRepository;
    @Autowired private LikeRepository likeRepository;
    @Autowired private MovieRepository movieRepository;
    @Autowired private SeriesRepository seriesRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private UserService userService;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        Long userId = userService.getCurrentUserId(principal);
        User user = userRepository.findById(userId).orElse(null);
        model.addAttribute("user", user);
        
        List<MovieFavorite> movieFavorites = movieFavoriteRepository.findByUserId(userId);
        List<SeriesFavorite> seriesFavorites = seriesFavoriteRepository.findByUserId(userId);
        
        List<Like> likes = likeRepository.findByUserId(userId);

        List<Movie> favoriteMovies = movieFavorites.stream()
                .map(f -> movieRepository.findById(f.getMovieId()).orElse(null))
                .filter(m -> m != null)
                .collect(Collectors.toList());
                
        List<Series> favoriteSeries = seriesFavorites.stream()
                .map(f -> seriesRepository.findById(f.getSeriesId()).orElse(null))
                .filter(s -> s != null)
                .collect(Collectors.toList());
                
        List<Movie> likedMovies = likes.stream()
                .filter(l -> l.getMovieId() != null)
                .map(l -> movieRepository.findById(l.getMovieId()).orElse(null))
                .filter(m -> m != null)
                .collect(Collectors.toList());
                
        List<Series> likedSeries = likes.stream()
                .filter(l -> l.getSeriesId() != null)
                .map(l -> seriesRepository.findById(l.getSeriesId()).orElse(null))
                .filter(s -> s != null)
                .collect(Collectors.toList());

        model.addAttribute("favoriteMovies", favoriteMovies);
        model.addAttribute("favoriteSeries", favoriteSeries);
        model.addAttribute("likedMovies", likedMovies);
        model.addAttribute("likedSeries", likedSeries);
        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute User formUser, @RequestParam(required = false) String password, Principal principal) {
        Long userId = userService.getCurrentUserId(principal);
        User user = userRepository.findById(userId).orElseThrow();
        user.setUsersName(formUser.getUsersName());
        user.setUsersSurname(formUser.getUsersSurname());
        user.setEmail(formUser.getEmail());
        user.setUsername(formUser.getUsername());
        if (password != null && !password.isBlank()) {
            user.setPassword(passwordEncoder.encode(password));
        }
        userRepository.save(user);
        return "redirect:/profile";
    }
} 