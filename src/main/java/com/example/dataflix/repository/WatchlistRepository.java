package com.example.dataflix.repository;

import com.example.dataflix.model.Watchlist;
import com.example.dataflix.model.WatchlistId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, WatchlistId> {
    List<Watchlist> findByUserId(Integer userId);
    
    Optional<Watchlist> findByUserIdAndContentIdAndContentType(Integer userId, Integer contentId, String contentType);
    
    void deleteByUserIdAndContentIdAndContentType(Integer userId, Integer contentId, String contentType);
}
