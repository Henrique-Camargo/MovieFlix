package com.movieflix.streaming;

import com.movieflix.streaming.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private StreamingRepository repository;

    

}
