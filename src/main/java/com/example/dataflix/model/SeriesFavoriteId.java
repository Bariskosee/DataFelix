package com.example.dataflix.model;

import java.io.Serializable;
import java.util.Objects;

public class SeriesFavoriteId implements Serializable {
    private Long userId;
    private Integer seriesId;

    public SeriesFavoriteId() {}
    public SeriesFavoriteId(Long userId, Integer seriesId) {
        this.userId = userId;
        this.seriesId = seriesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeriesFavoriteId)) return false;
        SeriesFavoriteId that = (SeriesFavoriteId) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(seriesId, that.seriesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, seriesId);
    }
} 