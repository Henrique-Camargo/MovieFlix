package com.movieflix.streaming.repository;

import com.movieflix.streaming.model.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {

}
