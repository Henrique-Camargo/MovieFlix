package com.movieflix.movie.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate realeseDate,
        Double rating,
        List<CategoryResponseDTO>categories,
        List<StreamingResponse>streamings
) {
}
