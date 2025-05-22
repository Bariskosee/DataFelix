package com.example.dataflix.service;

import com.example.dataflix.model.Rating;
import com.example.dataflix.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Optional<Rating> getUserRating(Integer userId, Integer contentId, String contentType) {
        return ratingRepository.findByUserIdAndContentIdAndContentType(userId, contentId, contentType);
    }

    public List<Rating> getContentRatings(Integer contentId, String contentType) {
        return ratingRepository.findByContentIdAndContentType(contentId, contentType);
    }

    public double getAverageRating(Integer contentId, String contentType) {
        List<Rating> ratings = getContentRatings(contentId, contentType);
        if (ratings.isEmpty()) {
            return 0.0;
        }
        
        int sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getRating();
        }
        
        return (double) sum / ratings.size();
    }

    @Transactional
    public Rating rateContent(Integer userId, Integer contentId, String contentType, Integer ratingValue) {
        if (ratingValue < 1 || ratingValue > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        
        Optional<Rating> existingRating = getUserRating(userId, contentId, contentType);
        
        if (existingRating.isPresent()) {
            Rating rating = existingRating.get();
            rating.setRating(ratingValue);
            return ratingRepository.save(rating);
        } else {
            Rating newRating = new Rating(userId, contentId, contentType, ratingValue);
            return ratingRepository.save(newRating);
        }
    }

    @Transactional
    public void removeRating(Integer userId, Integer contentId, String contentType) {
        ratingRepository.deleteByUserIdAndContentIdAndContentType(userId, contentId, contentType);
    }

    public List<Rating> getUserRatings(Integer userId) {
        return ratingRepository.findByUserId(userId);
    }
}
