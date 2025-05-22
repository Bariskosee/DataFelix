package com.example.dataflix.repository;

import com.example.dataflix.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserIdAndMovieId(Long userId, Integer movieId);
    Optional<Like> findByUserIdAndSeriesId(Long userId, Integer seriesId);
    List<Like> findByUserId(Long userId);
} 