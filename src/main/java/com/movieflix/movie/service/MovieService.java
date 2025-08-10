package com.movieflix.movie.service;

import com.movieflix.category.model.Category;
import com.movieflix.category.service.CategoryService;
import com.movieflix.movie.model.Movie;
import com.movieflix.movie.repository.MovieRepository;
import com.movieflix.streaming.model.Streaming;
import com.movieflix.streaming.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save (Movie movie){
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreaming(movie.getStreamings()));
        return repository.save(movie);
    }

    public List<Movie> findAll (){
        return repository.findAll();
    }

    public Optional<Movie> findById(Long id){
        return repository.findById(id);
    }

    public List<Category> findCategories(List<Category> categories){
        List<Category> categoryFound = new ArrayList<>();
            categories.forEach(category ->
                    categoryService.findById(category.getId()).ifPresent(categoryFound::add));
            return categoryFound;
    }

    public List<Streaming> findStreaming(List<Streaming> streamings){
        List<Streaming> streamingFound = new ArrayList<>();
        streamings.forEach(streaming ->
                    streamingService.findById(streaming.getId()).ifPresent(streamingFound::add));
            return streamingFound;
    }

}
