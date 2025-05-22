package com.example.dataflix.repository;

import com.example.dataflix.model.SeriesComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesCommentRepository extends JpaRepository<SeriesComment, Long> {
    List<SeriesComment> findBySeriesSeriesIdOrderByCommentDateDesc(Integer seriesId);
}
