package com.example.dataflix.service;

import com.example.dataflix.model.Series;
import com.example.dataflix.model.SeriesComment;
import com.example.dataflix.model.Users;
import com.example.dataflix.repository.SeriesCommentRepository;
import com.example.dataflix.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SeriesCommentService {

    private final SeriesCommentRepository seriesCommentRepository;
    private final SeriesRepository seriesRepository;
    
    @Autowired
    public SeriesCommentService(SeriesCommentRepository seriesCommentRepository, SeriesRepository seriesRepository) {
        this.seriesCommentRepository = seriesCommentRepository;
        this.seriesRepository = seriesRepository;
    }
    
    public SeriesComment addComment(Users user, Integer seriesId, String commentText) {
        Optional<Series> seriesOpt = seriesRepository.findById(seriesId);
        if (seriesOpt.isEmpty()) {
            throw new RuntimeException("Series not found");
        }
        
        SeriesComment comment = new SeriesComment();
        comment.setUser(user);
        comment.setSeries(seriesOpt.get());
        comment.setCommentText(commentText);
        comment.setCommentDate(LocalDateTime.now());
        
        return seriesCommentRepository.save(comment);
    }
    
    public List<SeriesComment> getCommentsBySeriesId(Integer seriesId) {
        return seriesCommentRepository.findBySeriesSeriesIdOrderByCommentDateDesc(seriesId);
    }
    
    public void deleteComment(Long commentId) {
        seriesCommentRepository.deleteById(commentId);
    }
}
