package com.movieflix.movie.response;

import com.movieflix.category.response.CategoryResponseDTO;
import com.movieflix.streaming.StreamingResponse;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        Long id,
        String title,
        String description,
        LocalDate realeseDate,
        Double rating,
        List<CategoryResponseDTO>categories,
        List<StreamingResponse>streamings
) {
}
