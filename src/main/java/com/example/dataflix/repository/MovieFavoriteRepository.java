package com.example.dataflix.repository;

import com.example.dataflix.model.MovieFavorite;
import com.example.dataflix.model.MovieFavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieFavoriteRepository extends JpaRepository<MovieFavorite, MovieFavoriteId> {
    // Kullanıcıya veya filme göre sorgular eklenebilir
    List<MovieFavorite> findByUserId(Long userId);
    Optional<MovieFavorite> findByUserIdAndMovieId(Long userId, Integer movieId);
} 