package com.example.dataflix.repository;

import com.example.dataflix.model.SeriesFavorite;
import com.example.dataflix.model.SeriesFavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeriesFavoriteRepository extends JpaRepository<SeriesFavorite, SeriesFavoriteId> {
    List<SeriesFavorite> findByUserId(Long userId);
    Optional<SeriesFavorite> findByUserIdAndSeriesId(Long userId, Integer seriesId);
} 