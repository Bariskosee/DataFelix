package com.example.dataflix.repository;

import com.example.dataflix.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
    // Arama ve özel sorgular eklenebilir

    @Query(value = "SELECT * FROM series ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Series> findRandomSeries(@Param("count") int count);

    List<Series> findBySeriesNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String seriesName, String description);
    
    Optional<Series> findBySeriesNameIgnoreCase(String seriesName);
} 