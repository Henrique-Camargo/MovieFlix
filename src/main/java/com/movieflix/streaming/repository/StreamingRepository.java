package com.movieflix.streaming.repository;

import com.movieflix.streaming.model.StreamingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StreamingRepository extends JpaRepository<StreamingModel, Long> {
}
