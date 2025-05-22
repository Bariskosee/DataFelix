package com.example.dataflix.repository;

import com.example.dataflix.model.Watched;
import com.example.dataflix.model.WatchedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchedRepository extends JpaRepository<Watched, WatchedId> {
    List<Watched> findByUserId(Integer userId);
    
    Optional<Watched> findByUserIdAndContentIdAndContentType(Integer userId, Integer contentId, String contentType);
    
    void deleteByUserIdAndContentIdAndContentType(Integer userId, Integer contentId, String contentType);
}
