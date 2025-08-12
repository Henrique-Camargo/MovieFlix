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

    public List<Movie> findMovieByCategories(Long categoryId){
        return repository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
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

    public Optional<Movie> update(Long movieId, Movie updateMovie){
        Optional<Movie> optMovie = repository.findById(movieId);
        if (optMovie.isPresent()){
            List<Category> categories = this.findCategories(updateMovie.getCategories());
            List<Streaming> streaming = this.findStreaming(updateMovie.getStreamings());

            Movie movie = optMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setRealeseDate(updateMovie.getRealeseDate());
            movie.setRating(updateMovie.getRating());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streaming);

            repository.save(movie);
            return Optional.of(movie);
        }
        return Optional.empty();

    }

    public void delete(Long id){
        repository.deleteById(id);
    }



}
