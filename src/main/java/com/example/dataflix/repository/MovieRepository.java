package com.example.dataflix.repository;

import com.example.dataflix.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM movies ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Movie> findRandomMovies(@Param("count") int count);

    List<Movie> findByMovieNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String movieName, String description);
    
    Optional<Movie> findByMovieNameIgnoreCase(String movieName);
} 