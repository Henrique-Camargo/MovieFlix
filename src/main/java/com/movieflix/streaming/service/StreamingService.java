package com.movieflix.streaming.service;

import com.movieflix.streaming.model.Streaming;
import com.movieflix.streaming.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public Streaming save(Streaming streaming){
        return repository.save(streaming);
    }

    public List<Streaming> findAll(){
        return repository.findAll();
    }

    public Optional<Streaming> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
