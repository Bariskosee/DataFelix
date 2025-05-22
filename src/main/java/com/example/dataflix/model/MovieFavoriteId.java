package com.example.dataflix.model;

import java.io.Serializable;
import java.util.Objects;

public class MovieFavoriteId implements Serializable {
    private Long userId;
    private Integer movieId;

    public MovieFavoriteId() {}
    public MovieFavoriteId(Long userId, Integer movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieFavoriteId)) return false;
        MovieFavoriteId that = (MovieFavoriteId) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, movieId);
    }
} 