package com.movieflix.movie.service;

import com.movieflix.movie.model.Movie;
import com.movieflix.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public Movie save (Movie movie){
        return repository.save(movie);
    }

    public List<Movie> findAll (){
        return repository.findAll();
    }

    public Optional<Movie> findById(Long id){
        return repository.findById(id);
    }

}
