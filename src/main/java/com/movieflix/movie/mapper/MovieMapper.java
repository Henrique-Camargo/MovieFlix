package com.movieflix.movie.mapper;

import com.movieflix.category.mapper.CategoryMapper;
import com.movieflix.category.model.Category;
import com.movieflix.movie.model.Movie;
import com.movieflix.movie.request.MovieRequest;
import com.movieflix.movie.response.MovieResponse;
import com.movieflix.streaming.mapper.StreamingMapper;
import com.movieflix.streaming.model.Streaming;
import com.movieflix.streaming.response.StreamingResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request){

        List<Category> categories = request.categories().stream()
                .map(categoryID -> Category.builder().id(categoryID).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingID -> Streaming.builder().id(streamingID).build())
                .toList();

        return Movie
                .builder()
                .title(request.title())
                .description(request.description())
                .realeseDate(request.realeseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie){

        List<com.movieflix.category.response.CategoryResponseDTO> categoryList = movie.getCategories().stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamingList = movie.getStreamings().stream()
                .map(streamings -> StreamingMapper.toStreamingResponse(streamings))
                .toList();

        return MovieResponse
                .builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .realeseDate(movie.getRealeseDate())
                .rating(movie.getRating())
                .categories(categoryList)
                .streamings(streamingList)
                .build();
    }
}
