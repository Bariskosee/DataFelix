package com.example.dataflix.repository;

import com.example.dataflix.model.Rating;
import com.example.dataflix.model.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId> {
    List<Rating> findByUserId(Integer userId);
    
    Optional<Rating> findByUserIdAndContentIdAndContentType(Integer userId, Integer contentId, String contentType);
    
    void deleteByUserIdAndContentIdAndContentType(Integer userId, Integer contentId, String contentType);
    
    List<Rating> findByContentIdAndContentType(Integer contentId, String contentType);
}
