package com.example.dataflix.repository;

import com.example.dataflix.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findByUserIdAndMovieId(Long userId, Integer movieId);
    Optional<Favorite> findByUserIdAndSeriesId(Long userId, Integer seriesId);
    List<Favorite> findByUserId(Long userId);
} 